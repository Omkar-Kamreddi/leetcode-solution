// Last updated: 11/17/2026, 10:54:05 PM
1using System;
2
3public class Solution
4{
5    public int MinimumChanges(string s, int k)
6    {
7        int n = s.Length;
8        int?[,] partitionMemo = new int?[n, k + 1];
9        int?[,] costMemo = new int?[n, n + 1];
10
11        return Solve(0, k);
12
13        // Minimum edits to split s[start..n) into partsLeft pieces.
14        int Solve(int start, int partsLeft)
15        {
16            if (partsLeft == 1)
17            {
18                return GetCost(start, n);
19            }
20
21            if (partitionMemo[start, partsLeft] is int cached)
22            {
23                return cached;
24            }
25
26            int best = n;
27
28            // Leave at least two characters for each remaining piece.
29            int latestEnd = n - 2 * (partsLeft - 1);
30
31            for (int end = start + 2; end <= latestEnd; end++)
32            {
33                int edits = GetCost(start, end) + Solve(end, partsLeft - 1);
34                best = Math.Min(best, edits);
35            }
36
37            partitionMemo[start, partsLeft] = best;
38            return best;
39        }
40
41        // Minimum edits to make s[start..end) a semi-palindrome.
42        int GetCost(int start, int end)
43        {
44            if (costMemo[start, end] is int cached)
45            {
46                return cached;
47            }
48
49            int length = end - start;
50            int best = length;
51
52            for (int step = 1; step <= length / 2; step++)
53            {
54                if (length % step != 0)
55                {
56                    continue;
57                }
58
59                int edits = 0;
60                int groupLength = length / step;
61
62                for (int offset = 0; offset < step; offset++)
63                {
64                    int left = start + offset;
65                    int right = left + (groupLength - 1) * step;
66
67                    while (left < right)
68                    {
69                        if (s[left] != s[right])
70                        {
71                            edits++;
72                        }
73
74                        left += step;
75                        right -= step;
76                    }
77                }
78
79                best = Math.Min(best, edits);
80
81                if (best == 0)
82                {
83                    break;
84                }
85            }
86
87            costMemo[start, end] = best;
88            return best;
89        }
90    }
91}