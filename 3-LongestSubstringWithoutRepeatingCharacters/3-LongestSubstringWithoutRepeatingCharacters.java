// Last updated: 8/21/2026, 10:19:18 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3
4        int[] lastSeen = new int[128];
5
6        int maxLen = 0;
7        int left = 0;
8
9        for(int right =0; right<s.length(); right++){
10            char ch = s.charAt(right);
11
12            if(lastSeen[ch] > left){
13                left = lastSeen[ch];
14            }
15
16            lastSeen[ch] = right+1;
17
18            maxLen = Math.max(maxLen,right-left+1);
19        }
20        return maxLen;
21    }
22}