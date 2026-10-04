// Last updated: 10/4/2026, 9:51:42 PM
1public class Solution
2{
3    public bool CheckValidString(string s)
4    {
5        int low = 0;
6        int high = 0;
7
8        foreach (char c in s)
9        {
10            if (c == '(')
11            {
12                low++;
13                high++;
14            }
15            else if (c == ')')
16            {
17                low--;
18                high--;
19            }
20            else // '*'
21            {
22                low--;   // Treat '*' as ')'
23                high++;  // Treat '*' as '('
24            }
25
26            // Even the maximum possible balance is negative
27            if (high < 0)
28            {
29                return false;
30            }
31
32            // Balance cannot actually be negative
33            low = Math.Max(0, low);
34        }
35
36        return low == 0;
37    }
38}