// Last updated: 8/14/2026, 10:03:01 AM
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDist = Math.min(minDist, Math.abs(i - start));
            }
        }

        return minDist;
    }
}