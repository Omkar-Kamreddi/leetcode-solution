// Last updated: 8/21/2026, 4:21:14 PM
1class Solution {
2    public int longestSubarray(int[] nums) {
3        int left = 0, zeroCount = 0, maxLen = 0;
4
5        for (int right = 0; right < nums.length; right++) {
6            if (nums[right] == 0) {
7                zeroCount++;
8            }
9            // Shrink window until it has at most one zero
10            while (zeroCount > 1) {
11                if (nums[left] == 0) {
12                    zeroCount--;
13                }
14                left++;
15            }
16            maxLen = Math.max(maxLen, right - left);
17        }
18        return maxLen;
19    }
20}