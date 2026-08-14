// Last updated: 8/14/2026, 10:08:46 AM
class Solution {
    public boolean isPalindrome(String s) {

        if(s.equals(" ") || s.length() == 0)
            return true;

        StringBuilder str = new StringBuilder("");

        String lr = s.toLowerCase();

        for(char ch : lr.toCharArray()){
            if (Character.isLetterOrDigit(ch)) {
                str.append(ch);
            }
        }
        return check(str);
    }

    public boolean check(StringBuilder str){
        int i = 0, j = str.length()-1;
        while(i<=j){
            
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}