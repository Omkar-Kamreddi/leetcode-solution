// Last updated: 8/14/2026, 9:56:35 AM
import java.util.*;

class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String num;
    private Pair[][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        num = String.valueOf(x);
        int n = num.length();

        dp = new Pair[n][11][11][2];

        return dfs(0, 10, 10, 0, 1).waviness;
    }

    private Pair dfs(int pos,
                     int prev2,
                     int prev1,
                     int started,
                     int tight) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0 && dp[pos][prev2][prev1][started] != null) {
            return dp[pos][prev2][prev1][started];
        }

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair next = dfs(
                        pos + 1,
                        10,
                        10,
                        0,
                        nextTight
                );

                totalCount += next.count;
                totalWaviness += next.waviness;
                continue;
            }

            int add = 0;

            if (started == 1 && prev2 != 10) {
                if ((prev1 > prev2 && prev1 > digit) ||
                    (prev1 < prev2 && prev1 < digit)) {
                    add = 1;
                }
            }

            Pair next;

            if (started == 0) {
                next = dfs(
                        pos + 1,
                        10,
                        digit,
                        1,
                        nextTight
                );
            } else {
                next = dfs(
                        pos + 1,
                        prev1,
                        digit,
                        1,
                        nextTight
                );
            }

            totalCount += next.count;
            totalWaviness += next.waviness + (long) add * next.count;
        }

        Pair ans = new Pair(totalCount, totalWaviness);

        if (tight == 0) {
            dp[pos][prev2][prev1][started] = ans;
        }

        return ans;
    }
}