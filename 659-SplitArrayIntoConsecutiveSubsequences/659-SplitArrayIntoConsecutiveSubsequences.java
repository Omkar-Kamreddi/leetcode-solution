// Last updated: 8/14/2026, 10:06:10 AM

class Solution {

    public boolean isPossible(int[] nums) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {

            if (map.containsKey(num - 1)) {

                PriorityQueue<Integer> prevHeap = map.get(num - 1);

                int len = prevHeap.poll();

                if (prevHeap.isEmpty())
                    map.remove(num - 1);

                map.computeIfAbsent(num, k -> new PriorityQueue<>())
                        .offer(len + 1);

            } else {

                map.computeIfAbsent(num, k -> new PriorityQueue<>())
                        .offer(1);
            }
        }

        for (PriorityQueue<Integer> pq : map.values()) {

            while (!pq.isEmpty()) {

                if (pq.poll() < 3)
                    return false;
            }
        }

        return true;
    }
}
