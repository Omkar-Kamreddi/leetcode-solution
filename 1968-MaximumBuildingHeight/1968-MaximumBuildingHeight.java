// Last updated: 8/14/2026, 10:03:06 AM
import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        // Implicit restriction for building n
        list.add(new int[]{n, n - 1});

        list.sort(Comparator.comparingInt(a -> a[0]));

        int size = list.size();

        // Left -> Right
        for (int i = 1; i < size; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i - 1)[1] + dist
            );
        }

        // Right -> Left
        for (int i = size - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i + 1)[1] + dist
            );
        }

        int ans = 0;

        for (int i = 1; i < size; i++) {
            int id1 = list.get(i - 1)[0];
            int h1  = list.get(i - 1)[1];

            int id2 = list.get(i)[0];
            int h2  = list.get(i)[1];

            int dist = id2 - id1;

            ans = Math.max(ans, (h1 + h2 + dist) / 2);
        }

        return ans;
    }
}