// Last updated: 8/14/2026, 10:07:27 AM
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }

        return (total - sum);
        
    }
}