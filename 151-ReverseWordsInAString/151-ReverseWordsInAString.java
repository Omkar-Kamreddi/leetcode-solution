// Last updated: 8/14/2026, 10:08:11 AM
class Solution {
    public String reverseWords(String s) {
        String []words =s.trim().split("\\s+");

        int i = 0, j = words.length-1;

        while( i<=j ){
            
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;

            i++;
            j--;
        }
        String res = "";
        for(String word : words){
            res+=word+" ";
        }
        return res.trim();
    }
}