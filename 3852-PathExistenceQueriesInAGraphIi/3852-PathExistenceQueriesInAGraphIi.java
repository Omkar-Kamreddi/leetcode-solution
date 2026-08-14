// Last updated: 8/14/2026, 9:57:51 AM
class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

        int[] order = new int[n];   // order[pos] = original node id at sorted position pos
        int[] pos = new int[n];     // pos[originalId] = sorted position
        int[] sortedNums = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = idx[i];
            pos[idx[i]] = i;
            sortedNums[i] = nums[idx[i]];
        }

        // right[i] = farthest sorted index reachable directly from i (two pointer, monotonic)
        int[] right = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sortedNums[j + 1] - sortedNums[i] <= maxDiff) j++;
            right[i] = j;
        }

        // Union-Find on consecutive sorted pairs to determine connectivity
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i + 1 < n; i++) {
            if (sortedNums[i + 1] - sortedNums[i] <= maxDiff) {
                union(parent, i, i + 1);
            }
        }

        // Binary lifting table: up[k][i] = position reachable using 2^k hops starting at i
        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++; // safety margin
        int[][] up = new int[LOG][n];
        up[0] = right;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int u = queries[qi][0], v = queries[qi][1];
            if (u == v) { ans[qi] = 0; continue; }
            if (find(parent, pos[u]) != find(parent, pos[v])) { ans[qi] = -1; continue; }

            int a = pos[u], b = pos[v];
            if (a > b) { int t = a; a = b; b = t; }

            int cur = a, steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < b) {
                    cur = up[k][cur];
                    steps += (1 << k);
                }
            }
            steps++; // final hop to cover b (guaranteed to exist since same component)
            ans[qi] = steps;
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int a, int b) {
        int ra = find(parent, a), rb = find(parent, b);
        if (ra != rb) parent[ra] = rb;
    }
}