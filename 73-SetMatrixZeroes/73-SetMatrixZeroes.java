// Last updated: 8/18/2026, 5:33:23 PM
1import java.util.Hashtable;
2
3class Solution {
4    public void setZeroes(int[][] matrix) {
5
6        int m = matrix.length;
7        int n = matrix[0].length;
8
9        Hashtable<Integer,Boolean> zeroRow = new Hashtable<>();
10        Hashtable<Integer,Boolean> zeroCol = new Hashtable<>();
11
12        //trace 0 in matrix
13        for(int i=0; i<m; i++){
14            for(int j=0; j<n; j++){
15                if(matrix[i][j] == 0){
16                    zeroRow.put(i,true);
17                    zeroCol.put(j,true);
18                }
19
20            }
21        }
22        
23        //setting zero's in original matrix
24        for(int i=0; i<m; i++){
25            for(int j=0; j<n; j++){
26
27                if(zeroRow.containsKey(i) || zeroCol.containsKey(j)){
28                    matrix[i][j] = 0;
29                }
30
31            }
32        }
33    }
34}