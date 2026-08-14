// Last updated: 8/14/2026, 10:07:34 AM
class Solution {
    public boolean isAnagram(String s, String t) {

        char []ch1 = s.toCharArray();
        char []ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1,ch2);
        
    }
}