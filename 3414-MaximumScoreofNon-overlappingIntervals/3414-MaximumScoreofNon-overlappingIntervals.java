// Last updated: 9/12/2026, 10:12:19 PM
1import java.util.*;
2
3class Solution {
4
5    private static final int K = 4;
6
7    public int[] maximumWeight(List<List<Integer>> intervals) {
8
9        int n = intervals.size();
10
11        // [left, right, weight, originalIndex]
12        int[][] arr = new int[n][4];
13
14        for (int i = 0; i < n; i++) {
15            arr[i][0] = intervals.get(i).get(0);
16            arr[i][1] = intervals.get(i).get(1);
17            arr[i][2] = intervals.get(i).get(2);
18            arr[i][3] = i;
19        }
20
21        // Sort by left endpoint
22        Arrays.sort(arr, (a, b) -> {
23            if (a[0] != b[0]) {
24                return Integer.compare(a[0], b[0]);
25            }
26            return Integer.compare(a[1], b[1]);
27        });
28
29        // next[i] = first interval j such that arr[j].left > arr[i].right
30        int[] next = new int[n];
31
32        for (int i = 0; i < n; i++) {
33            next[i] = findNext(arr, i + 1, arr[i][1]);
34        }
35
36        /*
37         * dp[i][k] = maximum score from i onward
38         *            using at most k intervals.
39         */
40        long[][] dp = new long[n + 1][K + 1];
41
42        /*
43         * code[i][k] = lexicographically smallest set of
44         * original indices among solutions having dp[i][k] score.
45         *
46         * We store up to 4 indices inside one long.
47         * Each index uses 16 bits.
48         */
49        long[][] code = new long[n + 1][K + 1];
50
51        for (int i = n - 1; i >= 0; i--) {
52
53            for (int k = 1; k <= K; k++) {
54
55                // -------------------------
56                // 1. Skip current interval
57                // -------------------------
58                long skipScore = dp[i + 1][k];
59                long skipCode = code[i + 1][k];
60
61                dp[i][k] = skipScore;
62                code[i][k] = skipCode;
63
64                // -------------------------
65                // 2. Take current interval
66                // -------------------------
67                long takeScore =
68                        arr[i][2] + dp[next[i]][k - 1];
69
70                long takeCode =
71                        insert(code[next[i]][k - 1], arr[i][3]);
72
73                if (takeScore > dp[i][k]) {
74
75                    dp[i][k] = takeScore;
76                    code[i][k] = takeCode;
77
78                } else if (takeScore == dp[i][k]) {
79
80                    // Same score -> lexicographically smaller indices
81                    if (Long.compareUnsigned(takeCode, code[i][k]) < 0) {
82                        code[i][k] = takeCode;
83                    }
84                }
85            }
86        }
87
88        return decode(code[0][K]);
89    }
90
91    // Find first j >= start where arr[j][0] > right
92    private int findNext(int[][] arr, int start, int right) {
93
94        int low = start;
95        int high = arr.length;
96
97        while (low < high) {
98
99            int mid = low + (high - low) / 2;
100
101            if (arr[mid][0] > right) {
102                high = mid;
103            } else {
104                low = mid + 1;
105            }
106        }
107
108        return low;
109    }
110
111    /*
112     * Insert originalIndex into the sorted index list.
113     *
114     * Example:
115     * [2, 5] + 3 -> [2, 3, 5]
116     */
117    private long insert(long code, int originalIndex) {
118
119        int[] indices = new int[4];
120
121        // Decode
122        for (int i = 0; i < 4; i++) {
123
124            int value =
125                    (int) ((code >>> (48 - 16 * i)) & 0xFFFF);
126
127            indices[i] =
128                    (value == 0)
129                            ? Integer.MAX_VALUE
130                            : value - 1;
131        }
132
133        // Find insertion position
134        int pos = 0;
135
136        while (pos < 4 && indices[pos] < originalIndex) {
137            pos++;
138        }
139
140        // Shift right
141        for (int i = 3; i > pos; i--) {
142            indices[i] = indices[i - 1];
143        }
144
145        indices[pos] = originalIndex;
146
147        // Encode
148        long result = 0;
149
150        for (int i = 0; i < 4; i++) {
151
152            long value =
153                    (indices[i] == Integer.MAX_VALUE)
154                            ? 0
155                            : indices[i] + 1L;
156
157            result |= value << (48 - 16 * i);
158        }
159
160        return result;
161    }
162
163    // Convert encoded long back to int[]
164    private int[] decode(long code) {
165
166        int count = 0;
167
168        for (int i = 0; i < 4; i++) {
169
170            int value =
171                    (int) ((code >>> (48 - 16 * i)) & 0xFFFF);
172
173            if (value == 0) {
174                break;
175            }
176
177            count++;
178        }
179
180        int[] result = new int[count];
181
182        for (int i = 0; i < count; i++) {
183
184            int value =
185                    (int) ((code >>> (48 - 16 * i)) & 0xFFFF);
186
187            result[i] = value - 1;
188        }
189
190        return result;
191    }
192}