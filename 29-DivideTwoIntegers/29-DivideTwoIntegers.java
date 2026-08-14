// Last updated: 8/14/2026, 10:11:08 AM
class Solution {
    public int divide(int dividend, int divisor) {

        // handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int res = dividend/divisor;


        return res;
    }
}