// Last updated: 8/17/2026, 6:58:55 PM
1class Solution {
2
3    private int prifixSum[];
4    private int dp[][];
5
6    public int stoneGameV(int[] stoneValue) {
7        
8        int n = stoneValue.length;
9        dp = new int[n+1][n+1];
10
11        prifixSum = new int[n+1];
12
13        for(int i=0; i<n; i++){
14            prifixSum[i+1] = prifixSum[i] + stoneValue[i];
15            Arrays.fill(dp[i],-1);
16        }
17
18        return maxScore(0,n-1);
19    }
20
21    public int maxScore(int l,int r){
22
23        //Base case
24        if(l >= r){
25            return 0;
26        }
27
28        if(dp[l][r] != -1){
29            return dp[l][r];
30        }
31
32        //Explore choices
33        int best = 0;
34        for(int k = l; k<r; k++){
35
36            int leftSum = prifixSum[k+1] - prifixSum[l];
37            int rightSum = prifixSum[r+1] - prifixSum[k+1];
38
39            if(leftSum < rightSum){
40                best = Math.max(best,leftSum+maxScore(l,k));
41            }else if(leftSum > rightSum){
42                best = Math.max(best,rightSum+maxScore(k+1,r));
43            }else{
44                //alice has choices
45                best = Math.max(best, leftSum+maxScore(l,k));
46                best = Math.max(best,rightSum+maxScore(k+1,r));
47            }
48
49        }
50
51        return dp[l][r] = best;
52    }
53}