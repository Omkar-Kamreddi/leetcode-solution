// Last updated: 10/9/2026, 9:25:36 PM
1public class Solution
2{
3    public int MinInsertions(string s)
4    {
5        int insertions = 0;
6        int open = 0;
7
8        for (int i = 0; i < s.Length; i++)
9        {
10            if (s[i] == '(')
11            {
12                open++;
13            }
14            else
15            {
16                // Pair this ')' with the next ')' if possible
17                if (i + 1 < s.Length && s[i + 1] == ')')
18                {
19                    i++;
20                }
21                else
22                {
23                    // Insert the missing second ')'
24                    insertions++;
25                }
26
27                if (open > 0)
28                {
29                    open--;
30                }
31                else
32                {
33                    // Insert a matching '('
34                    insertions++;
35                }
36            }
37        }
38
39        // Every unmatched '(' needs two closing ')'
40        return insertions + open * 2;
41    }
42}