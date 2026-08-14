// Last updated: 8/14/2026, 10:02:52 AM
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int farthest = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int start = Math.max(current + minJump, farthest);
            int end = Math.min(current + maxJump, n - 1);

            for (int next = start; next <= end; next++) {
                if (s.charAt(next) == '0' && !visited[next]) {

                    if (next == n - 1) {
                        return true;
                    }

                    visited[next] = true;
                    queue.offer(next);
                }
            }

            farthest = end + 1;
        }

        return n == 1;
    }
}