// Last updated: 8/14/2026, 10:09:25 AM
class Solution {
    public int removeDuplicates(int[] nums) {

        //first two allowed
        int k = 2;

        for(int i=2; i<nums.length; i++){
            if(nums[i] != nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}