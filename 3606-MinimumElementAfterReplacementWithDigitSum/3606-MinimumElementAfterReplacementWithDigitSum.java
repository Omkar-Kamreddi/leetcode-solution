// Last updated: 8/14/2026, 9:58:38 AM
class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int x : nums) {
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            ans = Math.min(ans, sum);
        }

        return ans;
    }
}