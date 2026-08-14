// Last updated: 8/14/2026, 9:59:32 AM
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        
        // 1. Calculate the sum of the longest sequential prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        
        // 2. Find the smallest missing integer greater than or equal to the sum
        while (true) {
            boolean exists = false;
            
            for (int num : nums) {
                if (num == sum) {
                    exists = true;
                    break;
                }
            }
            
            // If the current sum is not found in the array, it's our answer
            if (!exists) {
                return sum;
            }
            
            // Otherwise, increment and check the next integer
            sum++;
        }
    }
}