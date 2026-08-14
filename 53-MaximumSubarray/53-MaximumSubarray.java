// Last updated: 8/14/2026, 10:10:09 AM
class Solution {
    
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i< nums.length; i++){
            //either continue with subarr or start fresh start with curr element!
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum , currSum);
        }   
        return maxSum; 
    }

}