// Last updated: 9/15/2026, 7:37:29 PM
1class Solution {
2    public int maxPalindromes(String s, int k) {
3        int n = s.length();
4
5        int dp[] = new int[n];
6        boolean[][] pal = new boolean[n][n];
7
8        for(int i = n -1; i>=0; i--){
9            for(int j=i; j<n; j++){
10                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || pal[i+1][j-1])){
11                    pal[i][j] = true;
12                }
13            }
14        }
15
16        Arrays.fill(dp,-1);
17        return findMaxPalindrom(s,k,0,dp,pal);
18    }
19    public int findMaxPalindrom(String s,int k,int start,int dp[],boolean [][]pal){
20        //Base case
21        if(start >= s.length()){
22            return 0;
23        }
24
25        if (dp[start] != -1) {
26            return dp[start];
27        }
28
29        //Choice 1: skip
30        int ans = findMaxPalindrom(s,k,start+1,dp,pal);
31
32        //choice 2: take
33        for(int end = start+k-1; end<s.length(); end++){
34
35            if(pal[start][end]){
36                int count = 1 + findMaxPalindrom(s,k,end+1,dp,pal);
37
38                ans = Math.max(ans,count);
39            }
40        }
41        return dp[start] = ans;
42    }
43}