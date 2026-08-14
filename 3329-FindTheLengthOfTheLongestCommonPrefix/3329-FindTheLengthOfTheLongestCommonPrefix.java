// Last updated: 8/14/2026, 9:59:19 AM
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<String> prefixSet = new HashSet<String>();

        for(int elem : arr1){
            String temp = Integer.toString(elem);
            for(int i=1; i<= temp.length(); i++){
                prefixSet.add(temp.substring(0,i));
            }
        }
        
        int maxLen = 0;

        for(int elem : arr2){
            String temp = Integer.toString(elem);
            for(int i=1; i<= temp.length(); i++){
                if(prefixSet.contains(temp.substring(0,i))){
                    maxLen = Math.max(maxLen,i);
                }
            }
        }
        return maxLen;
    }
}