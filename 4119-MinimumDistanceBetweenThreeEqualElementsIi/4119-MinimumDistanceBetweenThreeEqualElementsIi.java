// Last updated: 8/14/2026, 9:56:38 AM
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        // Constraints: 1 <= nums[i] <= n
        int[] first = new int[n + 1];   // older index
        int[] second = new int[n + 1];  // newer index
        
        for (int i = 0; i <= n; i++) {
            first[i] = -1;
            second[i] = -1;
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            
            // If we already have two previous occurrences,
            // form a triple: (first[val], second[val], i)
            if (first[val] != -1 && second[val] != -1) {
                ans = Math.min(ans, 2 * (i - first[val]));
            }
            
            // Shift last two occurrences
            first[val] = second[val];
            second[val] = i;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}