// Last updated: 9/14/2026, 5:55:10 PM
1class Solution {
2
3    public int orangesRotting(int[][] grid) {
4
5        int minutes = 0;
6        int fresh = 0;
7        Queue<int[]> queue = new LinkedList<>();
8
9        for(int i=0; i<grid.length; i++){
10            for(int j=0; j<grid[0].length; j++){
11                if(grid[i][j] == 2){
12                    queue.offer(new int[]{i,j});
13                }
14
15                if(grid[i][j] == 1){
16                    fresh++;
17                }
18            }
19        }
20
21        //Define the directions
22        int [][]directions = {{-1,0},{1,0},{0,-1},{0,1}};
23
24        while(!queue.isEmpty() && fresh > 0){
25
26            int levelSize = queue.size();
27
28            // One BFS level = one minute
29            for (int i = 0; i < levelSize; i++) {
30
31            int [] curr = queue.poll();
32
33
34            int r = curr[0];
35            int c = curr[1];
36
37            for(int dir[] : directions){
38
39                int nr = r + dir[0];
40                int nc = c + dir[1];
41
42                //out of bound
43                if(nr < 0 || nc<0 || nr>= grid.length || nc>= grid[0].length){
44                    continue;
45                }
46
47                // Fresh orange
48                    if (grid[nr][nc] == 1) {
49
50                        // Make it rotten
51                        grid[nr][nc] = 2;
52
53                        fresh--;
54
55                        // It will spread in the NEXT minute
56                        queue.offer(new int[]{nr, nc});
57                    }
58            }
59            }
60            minutes++;
61        }
62
63        if(fresh > 0){
64            return -1;
65        }
66        
67        return minutes;
68    }
69}