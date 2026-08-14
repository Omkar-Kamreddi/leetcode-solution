// Last updated: 8/14/2026, 9:56:48 AM
import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Transform array and build prefix sums
        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }
        
        // Coordinate compression of prefix sums
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            indexMap.put(sorted[i], i + 1); // 1-based index for Fenwick
        }
        
        Fenwick fenwick = new Fenwick(sorted.length);
        long result = 0;
        
        // Process prefix sums
        for (long p : prefix) {
            int idx = indexMap.get(p);
            // Count how many prefix sums are strictly smaller
            result += fenwick.query(idx - 1);
            // Add current prefix sum
            fenwick.update(idx, 1);
        }
        
        return result;
    }
    
    // Fenwick Tree implementation
    static class Fenwick {
        int[] tree;
        Fenwick(int n) { tree = new int[n + 1]; }
        
        void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += i & -i;
            }
        }
        
        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}
