// Last updated: 8/14/2026, 9:56:10 AM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            // Calculate weight of current word
            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            // Modulo 26
            int mod = sum % 26;

            // Reverse alphabet mapping
            char mapped = (char) ('z' - mod);

            ans.append(mapped);
        }

        return ans.toString();
    }
}