// Last updated: 9/11/2026, 5:27:15 PM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        int[] freq = new int[10];
4
5        for (int digit : digits) {
6            freq[digit]++;
7        }
8
9        int count = 0;
10
11        for (int h = 1; h <= 9; h++) {
12            if (freq[h] == 0) {
13                continue;
14            }
15
16            freq[h]--;
17
18            for (int t = 0; t <= 9; t++) {
19                if (freq[t] == 0) {
20                    continue;
21                }
22
23                freq[t]--;
24
25                for (int u = 0; u <= 8; u += 2) {
26                    if (freq[u] > 0) {
27                        count++;
28                    }
29                }
30
31                freq[t]++;
32            }
33
34            freq[h]++;
35        }
36
37        return count;
38    }
39}