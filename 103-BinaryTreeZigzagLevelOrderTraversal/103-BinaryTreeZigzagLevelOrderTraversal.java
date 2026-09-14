// Last updated: 9/14/2026, 6:19:10 PM
1class Solution {
2    public int[][] updateMatrix(int[][] mat) {
3
4        int m = mat.length;
5        int n = mat[0].length;
6
7        int dist[][] = new int[m][n];
8        Queue<int[]> queue = new LinkedList<>();
9        
10        // 
11        for(int i=0; i<m; i++){
12            for(int j=0; j<n; j++){
13
14                if(mat[i][j] == 0){
15                    dist[i][j] = 0;
16                    queue.add(new int[]{i,j});
17                }else{
18                    //Not Processed
19                    dist[i][j] = -1;
20                }
21
22            }
23        }
24
25        //
26        int [][]directions = {{-1,0},{1,0},{0,-1},{0,1}};
27
28        //Multi-source BFS
29        while(!queue.isEmpty()){
30
31            int curr[] = queue.poll();
32
33            int r = curr[0];
34            int c = curr[1];
35
36            for (int[] direction : directions) {
37
38                int nr = r + direction[0];
39                int nc = c + direction[1];
40
41                // Check boundaries
42                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
43                    continue;
44                }
45
46                // Already visited
47                if (dist[nr][nc] != -1) {
48                    continue;
49                }
50
51                // Distance = current distance + 1
52                dist[nr][nc] = dist[r][c] + 1;
53
54                queue.offer(new int[]{nr, nc});
55            }
56        }
57        return dist;
58    }
59}