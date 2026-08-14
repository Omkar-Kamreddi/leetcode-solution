// Last updated: 8/14/2026, 10:05:43 AM
class Solution {
    Integer[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        dp = new Integer[n][n];

        return maxScoreDiff(0,piles.length-1,piles)> 0;
    }

    private int maxScoreDiff(int left, int right, int[] piles) {

        if (left == right)
            return piles[left];

        if (dp[left][right] != null)
            return dp[left][right];

        int takeLeft = piles[left] - maxScoreDiff(left + 1, right, piles);

        int takeRight = piles[right] - maxScoreDiff(left, right - 1, piles);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }
}