// Last updated: 8/19/2026, 11:16:18 PM
1class Solution {
2
3    public int longestPalindrome(String s) {
4
5        Map<Character, Integer> map = new HashMap<>();
6
7        for (char ch : s.toCharArray()) {
8            map.put(ch, map.getOrDefault(ch, 0) + 1);
9        }
10
11        int length = 0;
12        boolean hasOdd = false;
13
14        for (int count : map.values()) {
15
16            // Use the largest even portion
17            length += (count / 2) * 2;
18
19            // Can this character be the center?
20            if (count % 2 == 1) {
21                hasOdd = true;
22            }
23        }
24
25        // One odd character can be placed in the center
26        if (hasOdd) {
27            length++;
28        }
29
30        return length;
31    }
32}