// Last updated: 8/21/2026, 6:57:41 PM
1class Solution {
2    int dp[][];
3
4    public int coinChange(int[] coins, int amount) {
5        int n = coins.length;
6
7        dp = new int[n+1][amount+1];
8
9        for(int temp[] : dp){
10            Arrays.fill(temp,-1);
11        }
12
13        int ans = minCoins(0,amount,coins,dp);
14        return ans == Integer.MAX_VALUE?-1:ans;
15    }
16
17    public int minCoins(int idx,int amt,int coins[],int dp[][]){
18        
19        //Base case
20        if(amt == 0){
21            return 0;
22        }
23
24        if(idx == coins.length){
25            return Integer.MAX_VALUE;
26        }
27
28        if(dp[idx][amt] != -1){
29            return dp[idx][amt];
30        }
31
32        //Not taken 
33        int notTaken = minCoins(idx+1,amt,coins,dp);
34
35        //Taken 
36        int taken = Integer.MAX_VALUE;
37
38        if(coins[idx] <= amt){
39            int res = minCoins(idx,amt-coins[idx],coins,dp);
40
41            if(res != Integer.MAX_VALUE){
42                taken = 1 + res;
43            }
44        }
45        return dp[idx][amt] = Math.min(taken,notTaken);
46    }   
47
48
49}