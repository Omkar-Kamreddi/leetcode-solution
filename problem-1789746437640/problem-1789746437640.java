// Last updated: 9/18/2026, 9:17:17 PM
1class Solution {
2
3    public List<String> maxNumOfSubstrings(String s) {
4
5        int n = s.length();
6
7        int[] first = new int[26];
8        int[] last = new int[26];
9
10        Arrays.fill(first, n);
11
12        // 1. Find first and last occurrence
13        for (int i = 0; i < n; i++) {
14
15            int c = s.charAt(i) - 'a';
16
17            first[c] = Math.min(first[c], i);
18            last[c] = i;
19        }
20
21        List<int[]> intervals = new ArrayList<>();
22
23        // 2. Construct smallest valid interval for each character
24        for (int c = 0; c < 26; c++) {
25
26            if (first[c] == n)
27                continue;
28
29            int l = first[c];
30            int r = last[c];
31
32            boolean valid = true;
33
34            for (int i = l; i <= r; i++) {
35
36                int x = s.charAt(i) - 'a';
37
38                // Character occurs before l
39                if (first[x] < l) {
40                    valid = false;
41                    break;
42                }
43
44                // Need to include all occurrences
45                r = Math.max(r, last[x]);
46            }
47
48            if (valid) {
49                intervals.add(new int[]{l, r});
50            }
51        }
52
53        // 3. Sort by ending position
54        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
55
56        // 4. Greedily select non-overlapping intervals
57        List<String> ans = new ArrayList<>();
58
59        int prevEnd = -1;
60
61        for (int[] interval : intervals) {
62
63            int l = interval[0];
64            int r = interval[1];
65
66            if (l > prevEnd) {
67
68                ans.add(s.substring(l, r + 1));
69
70                prevEnd = r;
71            }
72        }
73
74        return ans;
75    }
76}