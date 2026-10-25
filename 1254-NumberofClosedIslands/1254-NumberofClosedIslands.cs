// Last updated: 10/25/2026, 10:48:33 AM
1public class Solution {
2    //flood-fill technique : removing boundary-connected land
3
4    private int rows;
5    private int cols;
6
7    public int ClosedIsland(int[][] grid) {
8
9        rows = grid.Length;
10        cols = grid[0].Length;
11
12        //step 1) Remove land connected to the boundary 
13        for(int r =0; r<rows; r++){
14            Dfs(grid,r,0);
15            Dfs(grid,r,cols-1);
16        }
17
18        for(int c=0; c<cols; c++){
19            Dfs(grid,0,c);
20            Dfs(grid,rows-1,c);
21        }
22
23        // Step2) count the remaining island 
24        int count = 0;
25
26        for(int r=1; r<rows-1; r++){
27            for(int c=1; c<cols-1; c++){
28                if(grid[r][c] == 0){
29                    count++;
30                    Dfs(grid,r,c);
31                }
32            }
33        }
34
35        return count;
36    }
37
38    private void Dfs(int [][]grid, int r,int c){
39
40        //Stop if outside the grid
41        if(r < 0 || r>= rows || c<0 || c>= cols){
42            return;
43        }
44
45        //stop if water or already visited
46        if(grid[r][c] == 1)
47            return ;
48
49        //Mark visited before exploring neighbors.
50        grid[r][c] = 1;
51
52        Dfs(grid,r-1,c);
53        Dfs(grid,r+1,c);
54        Dfs(grid,r,c-1);
55        Dfs(grid,r,c+1);
56    }
57}