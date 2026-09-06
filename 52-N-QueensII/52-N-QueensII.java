// Last updated: 9/6/2026, 9:21:22 PM
1class Solution {
2
3    private int count = 0;
4
5    public int totalNQueens(int n) {
6        char[][] board = new char[n][n];
7
8        // Initially empty board
9        for (int i = 0; i < n; i++) {
10            for (int j = 0; j < n; j++) {
11                board[i][j] = '.';
12            }
13        }
14
15        placeQueen(0,n,board);
16
17        return count;
18    }
19
20    public void placeQueen(int row,int n,char [][]board){
21        
22        //Base case
23        if(row == n){
24            count++;
25            return;
26        }
27
28        //Try every col
29        for(int col = 0; col<n; col++){
30
31            //Check
32            if(isSafeToPlace(row,col,n,board)){
33
34            //Choose
35            board[row][col] = 'Q';
36
37            //Explore
38            placeQueen(row+1,n,board);
39
40            //Undo
41            board[row][col] = '.';
42            
43            }
44        }
45
46    }
47
48
49    public boolean isSafeToPlace(int row,int col,int n,char [][]board){
50
51        //check for same row
52        for(int i=0; i<row; i++){
53            if(board[i][col] == 'Q'){
54                return false;
55            }
56        }
57
58        //Check for upper-left diagonal
59        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
60            if(board[i][j] == 'Q'){
61                return false;
62            }
63        }
64
65        //check for upper-right diagonal 
66        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
67            if(board[i][j] == 'Q'){
68                return false;
69            }
70        }
71
72        return true;
73    }
74}