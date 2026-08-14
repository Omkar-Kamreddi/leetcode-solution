// Last updated: 8/14/2026, 10:04:29 AM
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        // Build value -> indices map
        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            while (size-- > 0) {
                int idx = queue.poll();

                //Jump Right
                if (idx + 1 < n && !visited[idx + 1]) {
                    //if i reach last index then return step..
                    if (idx + 1 == n - 1) return steps;

                    visited[idx + 1] = true;
                    queue.offer(idx + 1);
                }

                //Jump left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    //if i reach last index then return step..
                    if (idx - 1 == n - 1) return steps;

                    visited[idx - 1] = true;
                    queue.offer(idx - 1);
                }

                // Jump to all same-value indices
                List<Integer> sameVal = valueMap.getOrDefault(arr[idx], Collections.emptyList());
                for (int j : sameVal) {
                    
                    if (!visited[j]) {
                        //if i reach last index then return step..
                        if (j == n - 1) return steps;

                        visited[j] = true;
                        queue.offer(j);
                    }
                }
                
                // KEY OPTIMIZATION: clear to prevent revisiting
                valueMap.remove(arr[idx]);
            }
        }

        return steps; // unreachable per problem guarantee
    }
}