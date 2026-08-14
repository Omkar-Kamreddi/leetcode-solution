// Last updated: 8/14/2026, 10:05:35 AM
class Solution {
    public int fib(int n) {

        if(n <= 1)
            return n;
        
        int dp[] = {0,1,1};

        for(int i = 3; i<=n; i++){
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1]; 
        }
        return dp[2];
    }
}