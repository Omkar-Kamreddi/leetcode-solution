// Last updated: 8/14/2026, 10:03:24 AM
class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int currMax = 0, maxSum = 0;
        int currMin = 0, minSum =0;

        for(int n : nums){
            currMax = Math.max(n,currMax+n);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(n,currMin+n);
            minSum = Math.min(minSum,currMin);
        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}