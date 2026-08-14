// Last updated: 8/14/2026, 10:04:14 AM
import java.util.*;

class Solution {

    // Directions: up, down, left, right
    private static final int[][] DIRS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    // Allowed directions for each street type
    private static final Map<Integer, int[][]> MAP = new HashMap<>();

    static {
        MAP.put(1, new int[][]{{0, -1}, {0, 1}});   // left, right
        MAP.put(2, new int[][]{{-1, 0}, {1, 0}});   // up, down
        MAP.put(3, new int[][]{{0, -1}, {1, 0}});   // left, down
        MAP.put(4, new int[][]{{0, 1}, {1, 0}});    // right, down
        MAP.put(5, new int[][]{{0, -1}, {-1, 0}});  // left, up
        MAP.put(6, new int[][]{{0, 1}, {-1, 0}});   // right, up
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            for (int[] d : MAP.get(grid[r][c])) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                    continue;

                // Check reverse connection
                for (int[] back : MAP.get(grid[nr][nc])) {
                    if (nr + back[0] == r && nc + back[1] == c) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        break;
                    }
                }
            }
        }

        return false;
    }
}