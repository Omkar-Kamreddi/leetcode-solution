// Last updated: 9/17/2026, 7:25:56 PM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3
4        int n = arr.length;
5        int INF = 1_000_000;
6
7        // best[i] = shortest target-sum subarray
8        // completely inside [0...i]
9        int[] best = new int[n];
10
11        for (int i = 0; i < n; i++) {
12            best[i] = INF;
13        }
14
15        int left = 0;
16        int sum = 0;
17        int answer = INF;
18
19        for (int right = 0; right < n; right++) {
20
21            // Expand window
22            sum += arr[right];
23
24            // Shrink while sum is too large
25            while (sum > target) {
26                sum -= arr[left];
27                left++;
28            }
29
30            // Found a target-sum subarray
31            if (sum == target) {
32
33                int length = right - left + 1;
34
35                // Check if a previous non-overlapping
36                // subarray exists
37                if (left > 0 && best[left - 1] != INF) {
38                    answer = Math.min(
39                        answer,
40                        length + best[left - 1]
41                    );
42                }
43
44                // This is the best single subarray
45                // ending up to 'right'
46                if (right == 0) {
47                    best[right] = length;
48                } else {
49                    best[right] = Math.min(
50                        best[right - 1],
51                        length
52                    );
53                }
54
55            } else {
56
57                // No new valid subarray ending at right
58                if (right > 0) {
59                    best[right] = best[right - 1];
60                }
61            }
62        }
63
64        return answer == INF ? -1 : answer;
65    }
66}