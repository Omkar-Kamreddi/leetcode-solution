// Last updated: 9/10/2026, 9:07:55 PM
1class Solution {
2
3    public int sumSubarrayMins(int[] arr) {
4
5        int n = arr.length;
6        long[] dp = new long[n];
7
8        Stack<Integer> stack = new Stack<>();
9
10        long sum = 0;
11        int MOD = 1_000_000_007;
12
13        for (int i = 0; i < n; i++) {
14
15            // Find previous smaller element
16            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
17                stack.pop();
18            }
19
20            int prev = stack.isEmpty() ? -1 : stack.peek();
21
22            // Calculate dp[i]
23            if (prev == -1) {
24                dp[i] = (long) arr[i] * (i + 1);
25            } else {
26                dp[i] = dp[prev] + (long) arr[i] * (i - prev);
27            }
28
29            dp[i] %= MOD;
30
31            // Add contribution of all subarrays ending at i
32            sum = (sum + dp[i]) % MOD;
33
34            stack.push(i);
35        }
36
37        return (int) sum;
38    }
39}