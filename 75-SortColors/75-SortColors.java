// Last updated: 8/14/2026, 10:09:32 AM
class Solution {
    public void sortColors(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}