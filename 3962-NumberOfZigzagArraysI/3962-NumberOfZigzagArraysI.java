// Last updated: 8/14/2026, 9:57:36 AM
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2
        for (int v = 0; v < m; v++) {
            up[v] = v;              // count of smaller values
            down[v] = m - 1 - v;    // count of larger values
        }

        if (n == 2) {
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            // newUp[y] = sum(dpDown[x]) for x < y
            long prefix = 0;
            for (int y = 0; y < m; y++) {
                newUp[y] = prefix;
                prefix = (prefix + down[y]) % MOD;
            }

            // newDown[y] = sum(dpUp[x]) for x > y
            long suffix = 0;
            for (int y = m - 1; y >= 0; y--) {
                newDown[y] = suffix;
                suffix = (suffix + up[y]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}