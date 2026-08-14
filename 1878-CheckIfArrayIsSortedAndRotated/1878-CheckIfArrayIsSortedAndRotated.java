// Last updated: 8/14/2026, 10:03:23 AM
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            // More than one drop means invalid
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}