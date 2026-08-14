// Last updated: 8/14/2026, 9:58:26 AM
import java.util.Arrays;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;

        // dp[i][j][k] -> max coins at (i,j) using k neutralizations
        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        // Base case (0,0)
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                // either take loss OR neutralize if possible
                dp[0][0][k] = (k > 0) ? 0 : coins[0][0];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {

                    if (i == 0 && j == 0) continue;

                    int best = Integer.MIN_VALUE;

                    // from top
                    if (i > 0) best = Math.max(best, dp[i - 1][j][k]);

                    // from left
                    if (j > 0) best = Math.max(best, dp[i][j - 1][k]);

                    if (best == Integer.MIN_VALUE) continue;

                    // Case 1: don't neutralize
                    int val = best + coins[i][j];

                    // Case 2: neutralize (if negative and k > 0)
                    if (coins[i][j] < 0 && k > 0) {
                        int prev = Integer.MIN_VALUE;

                        if (i > 0) prev = Math.max(prev, dp[i - 1][j][k - 1]);
                        if (j > 0) prev = Math.max(prev, dp[i][j - 1][k - 1]);

                        if (prev != Integer.MIN_VALUE) {
                            val = Math.max(val, prev); // neutralized → add 0
                        }
                    }

                    dp[i][j][k] = val;
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0],
               Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}