// Last updated: 8/14/2026, 10:06:42 AM
class Solution {
    public boolean predictTheWinner(int[] nums) {
        return maxScoreDiff(0,nums.length-1,nums) >= 0 ;
    }

    public int maxScoreDiff(int left,int right, int []nums){
        //Base case
        if(left == right){
            return nums[left];
        }

        int pickLeft = nums[left] - maxScoreDiff(left+1,right,nums);
        int pickRight = nums[right] - maxScoreDiff(left,right-1,nums);

        return Math.max(pickLeft,pickRight);
    }
}