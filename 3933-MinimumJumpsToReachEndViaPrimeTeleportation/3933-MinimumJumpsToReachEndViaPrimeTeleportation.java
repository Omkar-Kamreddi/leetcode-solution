// Last updated: 8/14/2026, 9:57:39 AM
import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        // prime -> all indices divisible by prime
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // build hashmap
        for (int i = 0; i < n; i++) {

            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {

                if (x % p == 0) {

                    map.putIfAbsent(p, new ArrayList<>());
                    map.get(p).add(i);

                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            if (x > 1) {
                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).add(i);
            }
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                // left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleport if nums[i] is prime
                if (isPrime(nums[i])) {

                    int prime = nums[i];

                    if (map.containsKey(prime)) {

                        for (int idx : map.get(prime)) {

                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }

                        // important optimization
                        map.remove(prime);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}