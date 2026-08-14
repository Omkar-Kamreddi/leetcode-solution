// Last updated: 8/14/2026, 9:56:50 AM
import java.util.*;

class Solution {

    static class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 2];
        }

        void update(int index, int val) {
            while (index < bit.length) {
                bit[index] += val;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        // Convert target -> +1, others -> -1
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == k ? 1 : -1);
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        FenwickTree bit = new FenwickTree(rank + 2);

        int ans = 0;

        for (int p : prefix) {
            int idx = map.get(p);

            // Count previous prefix sums smaller than current
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}