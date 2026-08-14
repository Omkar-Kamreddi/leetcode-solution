// Last updated: 8/14/2026, 10:01:44 AM
import java.util.*;

class Solution {

    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        List<Integer> slots = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                slots.add(f[0]);
            }
        }

        int n = robot.size();
        int m = slots.size();

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, robot, slots);
    }

    private long solve(int i, int j, List<Integer> robot, List<Integer> slots) {

        // all robots assigned
        if (i == robot.size()) return 0;

        // no slots left
        if (j == slots.size()) return (long)1e15;

        if (dp[i][j] != -1) return dp[i][j];

        // Option 1: assign
        long assign = Math.abs((long)robot.get(i) - slots.get(j))
                    + solve(i + 1, j + 1, robot, slots);

        // Option 2: skip
        long skip = solve(i, j + 1, robot, slots);

        return dp[i][j] = Math.min(assign, skip);
    }
}