// Last updated: 8/14/2026, 10:03:42 AM
import java.util.Arrays;

class Solution {

    public int minimumEffort(int[][] tasks) {

        // Sort by (minimum - actual) descending
        Arrays.sort(tasks, (a, b) ->
                (b[1] - b[0]) - (a[1] - a[0]));

        int ans = 0;
        int current = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            // Increase initial energy if needed
            if (current < minimum) {
                ans += (minimum - current);
                current = minimum;
            }

            // Complete task
            current -= actual;
        }

        return ans;
    }
}