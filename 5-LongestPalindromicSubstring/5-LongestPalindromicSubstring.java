// Last updated: 8/14/2026, 10:12:12 AM
class Solution {
    public String longestPalindrome(String s) {
        int start = 0,end=0;
        if(s.length() < 1 || s == null)
            return "";

        for(int i=0; i<s.length(); i++){
            //for odd
            int len1 = expand(s,i,i);
            //for even
            int len2 = expand(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len > end -start){
                start = i - (len-1) / 2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }


        public int expand(String s,int left, int right){

            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            return right - left -1;
        }
  
    
}