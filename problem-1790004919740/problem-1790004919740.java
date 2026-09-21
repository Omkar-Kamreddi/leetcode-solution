// Last updated: 9/21/2026, 9:05:19 PM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3
4        long[] result = new long[k];
5
6        // Subarrays ending at previous index
7        int[] dp = new int[k];
8
9        for (int num : nums) {
10
11            int[] newDp = new int[k];
12
13            int x = num % k;
14
15            // Extend previous subarrays
16            for (int r = 0; r < k; r++) {
17
18                int newRemainder = (r * x) % k;
19
20                newDp[newRemainder] += dp[r];
21            }
22
23            // Start a new subarray [num]
24            newDp[x]++;
25
26            // Add all subarrays ending here to final answer
27            for (int r = 0; r < k; r++) {
28                result[r] += newDp[r];
29            }
30
31            dp = newDp;
32        }
33
34        return result;
35    }
36}