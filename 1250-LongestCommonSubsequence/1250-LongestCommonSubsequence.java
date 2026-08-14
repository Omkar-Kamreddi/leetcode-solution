// Last updated: 8/14/2026, 10:04:58 AM
class Solution {
    
    public static int t[][] = new int[1050][1050];

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1,text2,text1.length(),text2.length());
    }

    //Using Top-down approach DP
    public int lcs(String x,String y,int n,int m){

        //initialization
        for(int i=0; i<n+1; i++){
            t[i][0] = 0;
        }

        for(int j=0; j<m+1; j++){
            t[0][j] = 0;
        }

        //DP logic
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }

}