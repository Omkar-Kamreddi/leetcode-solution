// Last updated: 8/14/2026, 9:59:11 AM
class Solution {
    public int maximumLengthSubstring(String s) {

        int freq[] = new int[26];

        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int right=0; right < s.length(); right++){

            int idx = s.charAt(right) - 'a';

            freq[idx]++;

            //logic
            while(freq[idx] > 2){
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength,right-left+1);

        }
        return maxLength;
    }
}