// Last updated: 8/14/2026, 10:06:45 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0 ;

        for(int i=0; i< nums.length; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}