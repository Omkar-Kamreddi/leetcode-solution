// Last updated: 8/14/2026, 9:59:15 AM
class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        int len = s.length();

        for(int i=0; i< len; i++ ){

            if(s.charAt(i) == c){
                count++;
            }
        }
        return count*(count+1)/2;
    }
}