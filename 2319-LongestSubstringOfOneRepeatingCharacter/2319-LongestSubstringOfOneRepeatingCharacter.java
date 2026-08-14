// Last updated: 8/14/2026, 10:01:59 AM
class Solution {

    static class Node {
        int len;
        int pref;
        int suff;
        int best;

        char leftChar;
        char rightChar;

        Node() {}

        Node(int len, int pref, int suff, int best,
             char leftChar, char rightChar) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    private Node[] tree;
    private char[] s;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update the actual string
            this.s[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index, ch);

            // Root represents the entire string
            ans[i] = tree[1].best;
        }

        return ans;
    }

    // --------------------------------------------------
    // Build
    // --------------------------------------------------

    private void build(int node, int left, int right) {

        if (left == right) {

            char ch = s[left];

            tree[node] = new Node(
                    1,      // len
                    1,      // pref
                    1,      // suff
                    1,      // best
                    ch,     // leftChar
                    ch      // rightChar
            );

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // --------------------------------------------------
    // Update
    // --------------------------------------------------

    private void update(
            int node,
            int left,
            int right,
            int index,
            char ch) {

        if (left == right) {

            tree[node] = new Node(
                    1,
                    1,
                    1,
                    1,
                    ch,
                    ch
            );

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {

            update(
                    node * 2,
                    left,
                    mid,
                    index,
                    ch
            );

        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    index,
                    ch
            );
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // --------------------------------------------------
    // Merge two nodes
    // --------------------------------------------------

    private Node merge(Node left, Node right) {

        Node result = new Node();

        result.len = left.len + right.len;

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        // ----------------------------------------------
        // Prefix
        // ----------------------------------------------

        result.pref = left.pref;

        if (left.pref == left.len &&
                left.rightChar == right.leftChar) {

            result.pref = left.len + right.pref;
        }

        // ----------------------------------------------
        // Suffix
        // ----------------------------------------------

        result.suff = right.suff;

        if (right.suff == right.len &&
                left.rightChar == right.leftChar) {

            result.suff = right.len + left.suff;
        }

        // ----------------------------------------------
        // Best
        // ----------------------------------------------

        result.best = Math.max(
                left.best,
                right.best
        );

        // A repeating substring can cross the boundary
        if (left.rightChar == right.leftChar) {

            result.best = Math.max(
                    result.best,
                    left.suff + right.pref
            );
        }

        return result;
    }
}