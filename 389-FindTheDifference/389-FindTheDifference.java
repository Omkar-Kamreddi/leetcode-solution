// Last updated: 8/14/2026, 10:07:01 AM
class Solution {
    public char findTheDifference(String s, String t) {
        int sTemp = 0;
        int tTemp = 0;

        //s total 
        for(int i=0; i<s.length(); i++){
            sTemp+= s.charAt(i);
        }
        //t total
        for(int i=0; i<t.length(); i++){
            tTemp+= t.charAt(i);
        }

        int result =  tTemp - sTemp;

        char ch = (char) result;

        return ch;

    }
}