// Last updated: 10/2/2026, 11:15:47 PM
1public class Solution {
2    public IList<string> GenerateParenthesis(int n)
3{
4    List<string> result = new List<string>();
5
6    void Backtrack(string current, int open, int close)
7    {
8        // Base case
9        if (open == n && close == n)
10        {
11            result.Add(current);
12            return;
13        }
14
15        // Choice 1: Add '('
16        if (open < n)
17        {
18            Backtrack(current + "(", open + 1, close);
19        }
20
21        // Choice 2: Add ')'
22        if (close < open)
23        {
24            Backtrack(current + ")", open, close + 1);
25        }
26    }
27
28    Backtrack("", 0, 0);
29
30    return result;
31}
32}