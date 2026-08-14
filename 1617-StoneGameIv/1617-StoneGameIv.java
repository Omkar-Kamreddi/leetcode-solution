// Last updated: 8/14/2026, 10:03:55 AM
class Solution {

    Boolean[] memo;

    public boolean winnerSquareGame(int n) {

        memo = new Boolean[n + 1];

        return solve(n);
    }

    private boolean solve(int n) {

        if (n == 0) {
            return false;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        for (int x = 1; x * x <= n; x++) {

            int square = x * x;

            if (!solve(n - square)) {

                return memo[n] = true;
            }
        }

        return memo[n] = false;
    }
}