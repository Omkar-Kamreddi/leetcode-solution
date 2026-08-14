// Last updated: 8/14/2026, 10:06:49 AM
class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Convert to list
        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(freq.entrySet());

        // Sort by frequency (descending)
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                ans.append(entry.getKey());
            }
        }

        return ans.toString();
    }
}