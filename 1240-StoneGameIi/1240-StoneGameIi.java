// Last updated: 8/14/2026, 10:05:03 AM
class Solution {

    int[][] memo;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // suffix[i] = sum of piles from i to n-1
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        memo = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles left
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        // Already calculated
        if (memo[i][M] != -1) {
            return memo[i][M];
        }

        int best = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M; X++) {

            int newM = Math.max(M, X);

            int opponent = solve(i + X, newM);

            int currentPlayer =
                    suffix[i] - opponent;

            best = Math.max(best, currentPlayer);
        }

        return memo[i][M] = best;
    }
}