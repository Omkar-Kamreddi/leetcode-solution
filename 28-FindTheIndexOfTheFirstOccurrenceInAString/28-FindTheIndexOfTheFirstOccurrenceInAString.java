// Last updated: 8/14/2026, 10:11:11 AM
class Solution {
    public int strStr(String haystack, String needle) {

        int index = haystack.indexOf(needle);

        if(index == -1){
            return -1;
        }
        else {
            return index;
        }
        
    }
}