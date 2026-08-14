// Last updated: 8/14/2026, 10:02:12 AM
class Solution {
    public int minimumCost(int[] cost) {
        
        // Step 1: Sort in ascending order
        Arrays.sort(cost);
        
        int total = 0;
        int n = cost.length;
        
        // Step 2: Traverse from right (highest to lowest)
        // Every 3rd candy (index 2, 5, 8...) is FREE → skip it
        for (int i = n - 1; i >= 0; i--) {
            
            // (n-1-i) gives position from top: 0, 1, 2, 3, 4, 5...
            // When position % 3 == 2 → it's the free candy → skip
            if ((n - 1 - i) % 3 == 2) {
                continue; // FREE candy, don't add to total
            }
            
            total += cost[i];
        }
        
        return total;
    }
}