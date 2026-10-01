// Last updated: 10/1/2026, 10:50:57 PM
1public class Solution
2{
3    public bool IsValid(string s)
4    {
5        Stack<char> stack = new Stack<char>();
6
7        foreach (char c in s)
8        {
9            // Opening brackets
10            if (c == '(' || c == '[' || c == '{')
11            {
12                stack.Push(c);
13            }
14            else
15            {
16                // No opening bracket available
17                if (stack.Count == 0)
18                    return false;
19
20                char top = stack.Pop();
21
22                // Check matching pair
23                if ((c == ')' && top != '(') ||
24                    (c == ']' && top != '[') ||
25                    (c == '}' && top != '{'))
26                {
27                    return false;
28                }
29            }
30        }
31
32        // All brackets should have been closed
33        return stack.Count == 0;
34    }
35}