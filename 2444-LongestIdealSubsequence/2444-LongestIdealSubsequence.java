// Last updated: 8/14/2026, 10:01:55 AM
class Solution {
    int dp[][];

    public int longestIdealString(String s, int k) {

        int n = s.length();
        dp = new int[n][27];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 26, s, k); // 26 means no previous char
        
    }
     private int solve(int index, int prev, String s, int k) {
        // Base case
        if (index == s.length())
            return 0;

        if (dp[index][prev] != -1)
            return dp[index][prev];

        // Option 1: skip current character
        int skip = solve(index + 1, prev, s, k);

        // Option 2: take current character (if valid)
        int take = 0;
        int curr = s.charAt(index) - 'a';

        if (prev == 26 || Math.abs(curr - prev) <= k) {
            take = 1 + solve(index + 1, curr, s, k);
        }

        return dp[index][prev] = Math.max(take, skip);
    }
}