// Last updated: 8/14/2026, 10:01:24 AM
import java.util.*;

class Solution {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }

        // Step 2: Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Find
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };

        // Union
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.applyAsInt(a);
            int pb = find.applyAsInt(b);
            if (pa != pb) parent[pa] = pb;
        };

        // Step 3: Merge positions with lcp > 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union.accept(i, j);
                }
            }
        }

        // Step 4: Assign characters (greedy)
        char[] res = new char[n];
        Map<Integer, Character> map = new HashMap<>();
        char ch = 'a';

        for (int i = 0; i < n; i++) {
            int root = find.applyAsInt(i);
            if (!map.containsKey(root)) {
                if (ch > 'z') return ""; // more than 26 groups → impossible
                map.put(root, ch++);
            }
            res[i] = map.get(root);
        }

        // Step 5: Validate by recomputing LCP
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(res);
    }
}