// Last updated: 8/14/2026, 10:04:24 AM
class Solution {
    private int[] dp;
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(arr, d, i, n));
        }
        return result;
    }
    
    private int dfs(int[] arr, int d, int i, int n) {
        if (dp[i] != 0) return dp[i];
        
        dp[i] = 1; // can always count itself
        
        // Jump RIGHT: i+1 to i+d
        for (int x = 1; x <= d && i + x < n; x++) {
            if (arr[i + x] >= arr[i]) break; // blocked by equal or taller bar
            dp[i] = Math.max(dp[i], 1 + dfs(arr, d, i + x, n));
        }
        
        // Jump LEFT: i-1 to i-d
        for (int x = 1; x <= d && i - x >= 0; x++) {
            if (arr[i - x] >= arr[i]) break; // blocked by equal or taller bar
            dp[i] = Math.max(dp[i], 1 + dfs(arr, d, i - x, n));
        }
        
        return dp[i];
    }
}