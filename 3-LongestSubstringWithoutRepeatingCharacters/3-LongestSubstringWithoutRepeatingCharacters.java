// Last updated: 8/14/2026, 10:12:17 AM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and the start is less than or equal to the last index of this character
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }

            // Update the last index of the character
            map.put(currentChar, end);

            // Calculate the max length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
        
    }
}