// Last updated: 8/14/2026, 9:58:21 AM
import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;

        // Step 1: value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        // Step 2: process each query
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int size = list.size();

            // Binary search to find index of q in list
            int pos = Collections.binarySearch(list, q);

            // left neighbor (circular)
            int left = list.get((pos - 1 + size) % size);
            int d1 = Math.abs(q - left);

            // right neighbor (circular)
            int right = list.get((pos + 1) % size);
            int d2 = Math.abs(q - right);

            // circular minimum distance
            int dist = Math.min(Math.min(d1, n - d1), Math.min(d2, n - d2));

            ans.add(dist);
        }

        return ans;
    }
}