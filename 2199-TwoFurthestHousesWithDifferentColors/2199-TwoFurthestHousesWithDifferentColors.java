// Last updated: 8/14/2026, 10:02:25 AM
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        // Compare first house with others
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
            }
        }

        // Compare last house with others
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, (n - 1 - i));
            }
        }

        return max;
    }
}