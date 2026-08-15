// Last updated: 8/15/2026, 7:16:55 PM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xor = 0;
4        boolean hasNonZero = false;
5
6        for (int num : nums) {
7            xor ^= num;
8            if (num != 0) {
9                hasNonZero = true;
10            }
11        }
12
13        if (!hasNonZero) {
14            return 0;
15        }
16
17        return xor != 0 ? nums.length : nums.length - 1;
18    }
19}