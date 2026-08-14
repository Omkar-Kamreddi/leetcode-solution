// Last updated: 8/14/2026, 10:03:59 AM
class Solution {

    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {

        dp = new Integer[stoneValue.length];

        int diff = solve(0, stoneValue);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";

        return "Tie";
    }

    private int solve(int index, int[] stone) {

        if (index >= stone.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int sum = 0;

        int best = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && index + k < stone.length; k++) {

            sum += stone[index + k];

            best = Math.max(best,
                    sum - solve(index + k + 1, stone));
        }

        return dp[index] = best;
    }

}