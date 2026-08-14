// Last updated: 8/14/2026, 10:00:42 AM
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] result = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            // Process A[i]
            freq[A[i]]++;
            if (freq[A[i]] == 2) common++;

            // Process B[i]
            freq[B[i]]++;
            if (freq[B[i]] == 2) common++;

            result[i] = common;
        }

        return result;
    }
}