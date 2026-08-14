// Last updated: 8/14/2026, 10:00:06 AM
class Solution {

    int []rowDir = {-1,1,0,0};
    int []colDir = {0,0,-1,1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        Queue<int[]> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];
        int [][]distToThief = new int[n][n];

        //Multi-Source BFS initialization
        for(int i=0; i <n; i++){
            for(int j=0; j<n; j++){

                if(grid.get(i).get(j) == 1){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }

            }
        }        

        //Compute distance of every cell from nearest theif
        int len = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int []curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                distToThief[row][col] = len;

                for(int k=0; k< 4; k++){
                    int newRow = row + rowDir[k];
                    int newCol = col + colDir[k];

                    if(!isValid(visited,newRow,newCol))
                        continue;
                    
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow,newCol});
                }

            }
            len++;
        }
        //Binary search on answer

        int low = 0;
        int high = len;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low )/2;

            if(isSafe(distToThief,mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(boolean[][] visited, int r,int c){
        int n = visited.length;

        if(r < 0 || c < 0 || r>=n || c >= n)
            return false;
        
        if(visited[r][c])
            return false;
        
        return true;
    }   

    //Check if there exists a path whose minimum safeness >= safeDist
    private boolean isSafe(int [][]distToThief,int safeDist){
        int n = distToThief.length;

        if(distToThief[0][0] < safeDist)
            return false;
    

        Queue<int[]> q = new LinkedList<>();

        boolean [][]visited = new boolean[n][n];

        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int []curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            if(row == n-1 && col == n-1)
                return true;
        
            //Explore the 4 direction
            for(int k =0; k<4; k++){

                int newRow = row + rowDir[k];
                int newCol = col + colDir[k];

                if(!isValid(visited,newRow,newCol))
                    continue;
            
                if(distToThief[newRow][newCol] < safeDist)
                    continue;
            
                visited[newRow][newCol] = true;
                q.offer(new int[]{newRow,newCol});
            }

        }
        return false;
    }
}