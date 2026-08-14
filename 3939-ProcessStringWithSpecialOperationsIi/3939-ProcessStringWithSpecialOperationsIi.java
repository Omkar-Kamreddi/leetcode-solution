// Last updated: 8/14/2026, 9:57:38 AM
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long len = 0;
        long MAX = (long) 1e15;

        // Forward pass: record length after each operation
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len = Math.min(len * 2, MAX);
            } else if (c == '%') {
                // length unchanged
            } else {
                len++;
            }
            lengths[i] = len;
        }

        // If k is out of bounds
        if (k >= lengths[n - 1]) return '.';

        // Backward pass: trace index k back to original character
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (c == '*') {
                // remove last char: length was prevLen+1 before... 
                // Actually lengths[i] = prevLen - 1
                // k is valid index in lengths[i], no change to k needed
                // but if k == prevLen-1 (the removed char) we'd never reach here
                // k stays same, maps to same position in prevLen string
            } else if (c == '#') {
                // lengths[i] = min(prevLen*2, MAX)
                // If actual doubling happened (prevLen*2 <= MAX):
                if (prevLen * 2 <= MAX) {
                    if (k >= prevLen) {
                        k = k - prevLen; // right half mirrors left half
                    }
                }
                // if capped, k stays (it's within prevLen already since MAX=prevLen)
            } else if (c == '%') {
                // reverse: k -> prevLen - 1 - k
                k = prevLen - 1 - k;
            } else {
                // letter appended: lengths[i] = prevLen + 1
                if (k == prevLen) {
                    // k points to this character
                    return c;
                }
                // else k is in the previous part, continue
            }
        }

        return '.'; // Should never reach here
    }
}