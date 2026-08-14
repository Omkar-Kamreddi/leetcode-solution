// Last updated: 8/14/2026, 10:05:23 AM
class Solution {

    int dp[][];
    int nums[];
    int n;

    public int solve(int prev,int curr){
        if(dp[prev][curr] != -1 )
            return dp[prev][curr];
        
        int diff = nums[curr]-nums[prev];
        int maxLen = 1; // only curr

        for(int next = curr + 1; next < n; next++){
            if(nums[next] - nums[curr] == diff){
                maxLen = Math.max(maxLen, 1 + solve(curr,next));
            }
        }

        return dp[prev][curr] = maxLen;
    }


    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        // dp[i] → map of (diff → length)
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int max = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int diff = nums[i] - nums[j];

                int len = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, len);

                max = Math.max(max, len);
            }
        }

        return max;
    }
}