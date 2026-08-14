// Last updated: 8/14/2026, 10:03:28 AM
import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // path compression
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parent[pa] = pb;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        // Step 1: Build connected components
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        // Step 2: Group indices by parent
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            map.putIfAbsent(parent, new HashMap<>());
            Map<Integer, Integer> freq = map.get(parent);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        // Step 3: Try to match target values
        int mismatch = 0;

        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            Map<Integer, Integer> freq = map.get(parent);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                mismatch++;
            }
        }

        return mismatch;
    }
}