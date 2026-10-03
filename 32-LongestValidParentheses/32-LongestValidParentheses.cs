// Last updated: 10/3/2026, 9:12:15 PM
1public class Solution
2{
3    public int LongestValidParentheses(string s)
4    {
5        int n = s.Length;
6
7        if (n < 2)
8            return 0;
9
10        int[] dp = new int[n];
11
12        int maxLength = 0;
13
14        for (int i = 1; i < n; i++)
15        {
16            // Current character must be ')'
17            if (s[i] == ')')
18            {
19                // Case 1: "()"
20                if (s[i - 1] == '(')
21                {
22                    dp[i] = 2;
23
24                    if (i >= 2)
25                    {
26                        dp[i] += dp[i - 2];
27                    }
28                }
29
30                // Case 2: "(())" or "()(()())"
31                else
32                {
33                    int openIndex = i - dp[i - 1] - 1;
34
35                    if (openIndex >= 0 && s[openIndex] == '(')
36                    {
37                        dp[i] = dp[i - 1] + 2;
38
39                        if (openIndex >= 1)
40                        {
41                            dp[i] += dp[openIndex - 1];
42                        }
43                    }
44                }
45
46                maxLength = Math.Max(maxLength, dp[i]);
47            }
48        }
49
50        return maxLength;
51    }
52}