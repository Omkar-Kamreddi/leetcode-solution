// Last updated: 8/14/2026, 10:07:23 AM
class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int k=0, i = 0;

        while(i < n){

            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
            i++;
        }

        while(k<n){
            nums[k] = 0;
            k++;
        }
        
    }
}