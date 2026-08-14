// Last updated: 8/14/2026, 9:58:41 AM
class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = last possible index in word1
        // that can match word2[j] while matching
        // the remaining suffix from right to left.
        int[] last = new int[m];

        Arrays.fill(last, -1);

        // Build suffix feasibility information
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // Greedily construct lexicographically smallest indices
        boolean canSkip = true;

        j = 0;

        for (i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }
            // Use the one allowed mismatch
            else if (canSkip &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;

                canSkip = false;
                j++;
            }
        }

        // Did we construct m indices?
        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}