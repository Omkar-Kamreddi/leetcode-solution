// Last updated: 8/14/2026, 10:05:40 AM
class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int currMax = 0, maxSum = nums[0];

        int currMin =0, minSum = nums[0];
        int total = 0;

        for(int n : nums){
            currMax = Math.max(n,currMax+n);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(n,currMin+n);
            minSum = Math.min(minSum,currMin);

            total += n;
        }

        if(maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total-minSum);       
    }
}