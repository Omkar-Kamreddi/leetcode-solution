// Last updated: 8/14/2026, 10:06:37 AM
class Solution {
    public static int t[][] = new int[1010][1010];

    public int longestPalindromeSubseq(String s) {

        int i=0,j=s.length()-1;
        char []ch = s.toCharArray();

        while(i<=j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        } 

        String revStr = new String(ch);

        return lcs(s,revStr,s.length(),revStr.length());
        
    }

    public static int lcs(String x,String y,int n,int m){
        //Initialization
        arrSet(t,0,n,m);

        //Choice diagram
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

    public static void arrSet(int t[][],int val,int n,int m){
        for(int i=0; i<n+1 ; i++){
            for(int j =0; j<m+1 ; j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
    }
}