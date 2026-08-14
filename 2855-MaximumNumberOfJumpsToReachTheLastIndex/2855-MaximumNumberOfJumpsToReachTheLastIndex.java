// Last updated: 8/14/2026, 10:00:11 AM
// Brute Force (O(n²))

// class Solution {
//     public int maximumJumps(int[] nums, int target) {

//         int n = nums.length;

//         int[] dp = new int[n];

//         Arrays.fill(dp, -1);

//         dp[0] = 0;

//         for (int i = 1; i < n; i++) {

//             for (int j = 0; j < i; j++) {

//                 if (dp[j] != -1 &&
//                     Math.abs(nums[i] - nums[j]) <= target) {

//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }

//         return dp[n - 1];
//     }
// }


//Recursion Brute FOrce :
// class Solution {

//     public int maximumJumps(int[] nums, int target) {

//         int ans = dfs(0, nums, target);

//         return ans < 0 ? -1 : ans;
//     }

//     private int dfs(int idx, int[] nums, int target) {

//         int n = nums.length;

//         if (idx == n - 1)
//             return 0;

//         int best = Integer.MIN_VALUE;

//         for (int next = idx + 1; next < n; next++) {

//             if (Math.abs(nums[next] - nums[idx]) <= target) {

//                 int res = dfs(next, nums, target);

//                 if (res != Integer.MIN_VALUE) {
//                     best = Math.max(best, 1 + res);
//                 }
//             }
//         }

//         return best;
//     }
// }


//Memoization Solution

class Solution {

    int[] memo;

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        memo = new int[n];

        Arrays.fill(memo, Integer.MIN_VALUE);

        int ans = solve(0, nums, target);

        return ans < 0 ? -1 : ans;
    }

    private int solve(int idx, int[] nums, int target) {

        int n = nums.length;

        if (idx == n - 1)
            return 0;

        if (memo[idx] != Integer.MIN_VALUE)
            return memo[idx];

        int best = -1000000;

        for (int next = idx + 1; next < n; next++) {

            if (Math.abs(nums[next] - nums[idx]) <= target) {

                int res = solve(next, nums, target);

                if (res != -1000000) {
                    best = Math.max(best, 1 + res);
                }
            }
        }

        return memo[idx] = best;
    }
}