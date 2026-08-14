// Last updated: 8/14/2026, 10:06:32 AM
class Solution {
    public String reverseWords(String s) {

        String []arr = s.split(" ");
        String res = "";

        for(String word : arr){

            char []ch = word.toCharArray();
            String temp = "";

            for(int i= ch.length -1 ; i>=0; i-- ){
                temp+=ch[i];
            }
            res+=(temp+" ");
        }
        return res.trim();
    }
}