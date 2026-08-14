// Last updated: 8/14/2026, 9:59:06 AM
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // best index for this suffix
        int index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = new TrieNode();

        // global best:
        // shortest string
        // if tie -> smallest index
        int best = 0;

        for (int i = 1; i < wordsContainer.length; i++) {

            if (wordsContainer[i].length() < wordsContainer[best].length()
                    || (wordsContainer[i].length() == wordsContainer[best].length()
                    && i < best)) {

                best = i;
            }
        }

        root.index = best;

        // build reversed trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(root, wordsQuery[i]);
        }

        return ans;
    }

    private void insert(TrieNode root, String word, int idx,
                        String[] wordsContainer) {

        TrieNode node = root;

        String rev = new StringBuilder(word).reverse().toString();

        for (char ch : rev.toCharArray()) {

            int c = ch - 'a';

            if (node.child[c] == null) {

                node.child[c] = new TrieNode();

                // first word reaching this node
                node.child[c].index = idx;
            }

            node = node.child[c];

            int current = node.index;

            // update best candidate
            if (wordsContainer[idx].length() < wordsContainer[current].length()
                    || (wordsContainer[idx].length() == wordsContainer[current].length()
                    && idx < current)) {

                node.index = idx;
            }
        }
    }

    private int search(TrieNode root, String word) {

        TrieNode node = root;

        String rev = new StringBuilder(word).reverse().toString();

        for (char ch : rev.toCharArray()) {

            int c = ch - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.index;
    }
}