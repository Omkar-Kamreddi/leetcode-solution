// Last updated: 8/14/2026, 9:58:07 AM
class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        // n = 1 -> {1}
        // n = 2 -> {1,2}
        if (n < 3)
            return n;

        // Smallest power of 2 strictly greater than n
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }

        return ans;
    }
}