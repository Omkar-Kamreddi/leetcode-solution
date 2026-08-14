// Last updated: 8/14/2026, 10:08:27 AM
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<String>(wordDict);

        int n = s.length();

        boolean dp[] = new boolean[n+1];

        dp[0] = true;

        for(int i=1; i<n+1; i++){
            for(int j=0; j<i; j++){
                if( dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}