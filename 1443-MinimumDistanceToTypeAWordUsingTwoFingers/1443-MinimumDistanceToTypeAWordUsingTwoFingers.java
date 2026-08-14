// Last updated: 8/14/2026, 10:04:38 AM
class Solution {

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];

        // initialize dp with large values
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        // both fingers initially free (26 represents no position)
        dp[26][26] = 0;

        for (char ch : word.toCharArray()) {
            int cur = ch - 'A';
            int[][] next = new int[27][27];

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    next[i][j] = Integer.MAX_VALUE / 2;
                }
            }

            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    int val = dp[f1][f2];
                    if (val == Integer.MAX_VALUE / 2) continue;

                    // move finger 1
                    int cost1 = val + dist(f1, cur);
                    next[cur][f2] = Math.min(next[cur][f2], cost1);

                    // move finger 2
                    int cost2 = val + dist(f2, cur);
                    next[f1][cur] = Math.min(next[f1][cur], cost2);
                }
            }

            dp = next;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }

    private int dist(int a, int b) {
        if (a == 26) return 0; // free finger
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}