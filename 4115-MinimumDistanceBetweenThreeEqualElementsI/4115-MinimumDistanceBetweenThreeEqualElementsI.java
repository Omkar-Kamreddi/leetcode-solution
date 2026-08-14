// Last updated: 8/14/2026, 9:56:43 AM
import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayDeque<>());
            Deque<Integer> dq = map.get(nums[i]);

            dq.addLast(i);

            if (dq.size() == 3) {
                int first = dq.peekFirst();
                int last = dq.peekLast();

                int dist = 2 * (last - first); // FIX
                min = Math.min(min, dist);

                dq.pollFirst();
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}