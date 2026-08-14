// Last updated: 8/14/2026, 10:02:50 AM
class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int r1 = 0, c1 = 0;
        int r2 = m - 1, c2 = n - 1;

        while (r1 < r2 && c1 < c2) {

            List<Integer> ring = new ArrayList<>();

            // top
            for (int j = c1; j < c2; j++)
                ring.add(grid[r1][j]);

            // right
            for (int i = r1; i < r2; i++)
                ring.add(grid[i][c2]);

            // bottom
            for (int j = c2; j > c1; j--)
                ring.add(grid[r2][j]);

            // left
            for (int i = r2; i > r1; i--)
                ring.add(grid[i][c1]);

            int len = ring.size();
            int shift = k % len;

            int idx = 0;
            
            //Instead of rotating array physically: -> we just compute rotated index:
            // top
            for (int j = c1; j < c2; j++)
                grid[r1][j] = ring.get((idx++ + shift) % len);

            // right
            for (int i = r1; i < r2; i++)
                grid[i][c2] = ring.get((idx++ + shift) % len);

            // bottom
            for (int j = c2; j > c1; j--)
                grid[r2][j] = ring.get((idx++ + shift) % len);

            // left
            for (int i = r2; i > r1; i--)
                grid[i][c1] = ring.get((idx++ + shift) % len);

            r1++;
            c1++;
            r2--;
            c2--;
        }

        return grid;
    }
}