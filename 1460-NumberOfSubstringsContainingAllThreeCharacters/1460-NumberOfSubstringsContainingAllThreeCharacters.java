// Last updated: 8/14/2026, 10:04:26 AM
class Solution {
    public int numberOfSubstrings(String s) {

        int freq[] = new int[3];

        int left = 0;
        int ans = 0;
        int n = s.length();

        //Sliding window 
        for(int right=0; right< n; right++){

            //Expanding
            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1]>0 && freq[2] > 0){
                
                //Key obervation
                ans += (n - right);

                //Shriking
                freq[s.charAt(left) - 'a']--;

                left++;
            }

        }
        return ans;
    }
}