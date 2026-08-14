// Last updated: 8/14/2026, 9:59:50 AM
class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;

        int shift = k % m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int expected;

                if (i % 2 == 0) {
                    // even → left shift
                    expected = mat[i][(j + shift) % m];
                } else {
                    // odd → right shift
                    expected = mat[i][(j - shift + m) % m];
                }

                if (mat[i][j] != expected) {
                    return false;
                }
            }
        }
        return true;
    }
}