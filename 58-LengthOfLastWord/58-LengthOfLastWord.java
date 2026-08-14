// Last updated: 8/14/2026, 10:09:56 AM
class Solution {
    public int lengthOfLastWord(String s) {

        String str = s.trim();

        String []arr = str.split(" ");

        return arr[arr.length - 1].length();
        
    }
}