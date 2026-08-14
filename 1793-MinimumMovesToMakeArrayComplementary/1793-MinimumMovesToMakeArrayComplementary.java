// Last updated: 8/14/2026, 10:03:40 AM
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        // Difference array for range updates
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            /*
                Initially every sum needs 2 moves.
                Then optimize ranges:

                [low, high] -> 1 move
                [sum] -> 0 move
            */

            // 2 moves for all by default
            diff[2] += 2;

            // reduce to 1 move in [low, high]
            diff[low] -= 1;
            diff[high + 1] += 1;

            // reduce to 0 move at exact sum
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int curr = 0;

        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}