// Last updated: 8/14/2026, 9:58:49 AM
class Solution {
    //0-1 BFS  algorithm
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        //Track
        int [][]dist = new int[m][n];

        for(int []row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        //starting cost
        dist[0][0] = grid.get(0).get(0);

        //for storing index (x,y)
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});

        //initial directions
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(!deque.isEmpty()){
            
            int curr[] = deque.pollFirst();

            int r = curr[0];
            int c = curr[1];

            //Explore the 4 directions
            for(int k = 0; k< 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                
                //Edge case
                if(nr < 0 || nr >= m || nc<0 || nc >=n)
                    continue;
                
                int cost = grid.get(nr).get(nc);

                //if curr cell cost + new cell cost < newCell
                if(dist[r][c]+cost < dist[nr][nc]){
                    
                    //i am going to update next cell cost
                    dist[nr][nc] = dist[r][c] + cost;

                    if(cost == 0){
                        // i want immediage explore that choice
                        deque.offerFirst(new int[]{nr,nc});
                    }else{
                        // i want explore that cell last*
                        deque.offerLast(new int[]{nr,nc});
                    }
                }
            }

        }

        return health - dist[m-1][n-1] >= 1;
    }
}