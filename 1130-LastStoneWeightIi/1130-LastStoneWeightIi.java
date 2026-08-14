// Last updated: 8/14/2026, 10:05:14 AM
class Solution {
    //0/1 Knapsack DP)
    //Let:

    //sum = total weight
    //target = sum / 2

    //We try to find the maximum subset sum ≤ target
    
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }

        return 0;
    }
}