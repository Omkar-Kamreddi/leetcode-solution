// Last updated: 8/22/2026, 4:08:41 PM
1class Solution {
2    public int characterReplacement(String s, int k) {
3        //AABABBA
4        int l = 0,r =0;
5        int maxLen = 0, maxFreq = 0;
6        int n = s.length();
7        int hash[] = new int[26];
8
9        //Two pointer and sliding window
10        while(r < n){
11            hash[s.charAt(r) - 'A']++;
12            maxFreq = Math.max(maxFreq,hash[s.charAt(r) - 'A']);
13
14            //shrink condition
15            while((r-l+1)-maxFreq > k){
16                maxFreq = 0;
17                hash[s.charAt(l)-'A']--;
18                for(int i=0; i<26; i++){
19                    maxFreq = Math.max(maxFreq,hash[i]);
20                }
21                l++;
22            }
23
24            //take it
25            if((r-l+1)-maxFreq <= k){
26                maxLen = Math.max(maxLen,r-l+1);
27            }
28            r++;
29        }
30        return maxLen;
31    }
32}