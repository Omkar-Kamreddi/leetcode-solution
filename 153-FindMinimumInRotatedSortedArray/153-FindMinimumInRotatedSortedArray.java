// Last updated: 8/14/2026, 10:08:14 AM
class Solution {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int elem : nums){
            if(elem < min){
                min = elem;
            }
        }
        return min;
    }
}