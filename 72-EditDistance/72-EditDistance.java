// Last updated: 8/18/2026, 8:03:16 PM
1class Solution {
2
3    private int dp[][];
4
5    public int minDistance(String word1, String word2) {
6
7        int m = word1.length();
8        int n = word2.length();
9
10        dp = new int[m][n];
11
12        for(int row[] : dp){
13            Arrays.fill(row,-1);
14        }
15
16        return minOperation(0,0,word1,word2,dp);
17    }
18
19    public int minOperation(int i,int j,String word1, String word2,int [][]dp){
20
21        //Base case
22        if(i == word1.length()){
23            //remaining char of word2
24            return word2.length() - j;
25        }
26
27        if(j == word2.length()){
28            return word1.length() - i;
29        }
30
31        if(dp[i][j] != -1){
32            return dp[i][j];
33        }
34
35        if(word1.charAt(i) == word2.charAt(j)){
36            //dont need op. return 
37            return dp[i][j] = minOperation(i+1,j+1,word1,word2,dp);
38        }
39
40        int insert = minOperation(i,j+1,word1,word2,dp);
41        int delete = minOperation(i+1,j,word1,word2,dp);
42        int replace = minOperation(i+1,j+1,word1,word2,dp);
43
44        return dp[i][j] =  1 + Math.min(insert,Math.min(delete,replace));
45    }
46
47
48}