// Last updated: 8/14/2026, 9:58:35 AM
class Solution {

    int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {

        int max = 0;

        for (int x : nums)
            max = Math.max(max, x);

        int[][][] dp = new int[nums.length + 1][max + 1][max + 1];

        dp[0][0][0] = 1;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            for (int g1 = 0; g1 <= max; g1++) {

                for (int g2 = 0; g2 <= max; g2++) {

                    int ways = dp[i][g1][g2];

                    if (ways == 0)
                        continue;

                    // Ignore
                    dp[i + 1][g1][g2] =
                            (dp[i + 1][g1][g2] + ways) % MOD;

                    // Put in first
                    int ng1 = gcd(g1, x);

                    dp[i + 1][ng1][g2] =
                            (dp[i + 1][ng1][g2] + ways) % MOD;

                    // Put in second
                    int ng2 = gcd(g2, x);

                    dp[i + 1][g1][ng2] =
                            (dp[i + 1][g1][ng2] + ways) % MOD;
                }
            }
        }

        long ans = 0;

        for (int g = 1; g <= max; g++)
            ans = (ans + dp[nums.length][g][g]) % MOD;

        return (int) ans;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}