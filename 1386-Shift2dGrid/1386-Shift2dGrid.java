// Last updated: 8/14/2026, 10:04:46 AM
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        // if k is greater than total element
        k = k % total;

        int [][]shifted = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j< cols; j++){

                int oldIdx = i * cols + j;

                int newIdx = (oldIdx + k)%total;

                int newRow = newIdx / cols;
                int newCol = newIdx % cols;

                shifted[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add(shifted[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }
}