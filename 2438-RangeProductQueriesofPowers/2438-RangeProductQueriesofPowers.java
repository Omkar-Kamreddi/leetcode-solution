// Last updated: 8/20/2026, 10:50:08 PM
1class Solution {
2
3    static final long MOD = 1_000_000_007;
4
5    public int[] productQueries(int n, int[][] queries) {
6
7        // Store exponents of powers of 2
8        int[] exponents = new int[31];
9
10        int count = 0;
11
12        for (int i = 0; i < 31; i++) {
13
14            if ((n & (1 << i)) != 0) {
15                exponents[count++] = i;
16            }
17        }
18
19        // Prefix sum of exponents
20        int[] prefix = new int[count + 1];
21
22        for (int i = 0; i < count; i++) {
23            prefix[i + 1] = prefix[i] + exponents[i];
24        }
25
26        int[] answer = new int[queries.length];
27
28        for (int i = 0; i < queries.length; i++) {
29
30            int left = queries[i][0];
31            int right = queries[i][1];
32
33            // Sum of exponents in [left, right]
34            int exponent = prefix[right + 1] - prefix[left];
35
36            answer[i] = (int) power(2, exponent);
37        }
38
39        return answer;
40        
41    }
42
43    private long power(long base, int exponent) {
44
45        long result = 1;
46
47        while (exponent > 0) {
48
49            if ((exponent & 1) == 1) {
50                result = (result * base) % MOD;
51            }
52
53            base = (base * base) % MOD;
54            exponent >>= 1;
55        }
56
57        return result;
58    }
59}