// Last updated: 8/18/2026, 10:11:29 PM
1class Solution {
2    public int maxCoins(int[] nums) {
3        int n = nums.length;
4
5        int ballons[] = new int[n+2];
6        //Adding virtual balloon to both boundris
7        ballons[0] = 1;
8        ballons[n+1] = 1;
9        for (int i = 0; i < n; i++) {
10            ballons[i + 1] = nums[i];
11        }
12
13
14        int[][] dp = new int[n + 2][n + 2];
15
16        //max coins make excluding boundry balloon
17        return maxCoins(0,n+1,ballons,dp);
18    }
19
20    public int maxCoins(int left,int right,int []ballons,int dp[][]){
21
22        //base case
23        if(left+1 == right){
24            return 0;
25        }
26        
27        if(dp[left][right] != 0){
28            return dp[left][right];
29        }
30
31        int max = 0;
32
33        for (int k = left + 1; k < right; k++) {
34
35            int coins =
36                    maxCoins(left, k,ballons,dp)
37                    + ballons[left] * ballons[k] * ballons[right]
38                    + maxCoins(k, right,ballons,dp);
39
40            max = Math.max(max, coins);
41        }
42
43        return dp[left][right] = max;
44    }
45}