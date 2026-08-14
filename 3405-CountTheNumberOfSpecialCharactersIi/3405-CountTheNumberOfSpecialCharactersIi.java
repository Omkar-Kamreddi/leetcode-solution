// Last updated: 8/14/2026, 9:59:03 AM
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, Integer.MAX_VALUE);
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLower[c - 'a'] = i;                    // track last lowercase index
            } else {
                int idx = c - 'A';
                if (firstUpper[idx] == Integer.MAX_VALUE) {
                    firstUpper[idx] = i;                   // track first uppercase index
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < 26; i++) {
            // special if both exist AND all lowercase come before first uppercase
            if (lastLower[i] != -1 && firstUpper[i] != Integer.MAX_VALUE 
                && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }
}