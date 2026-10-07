// Last updated: 10/7/2026, 8:27:53 PM
1public class Solution
2{
3    public IList<string> RemoveInvalidParentheses(string s)
4    {
5        List<string> result = new List<string>();
6
7    //BFS
8        Queue<string> queue = new Queue<string>();
9        HashSet<string> visited = new HashSet<string>();
10
11        queue.Enqueue(s);
12        visited.Add(s);
13
14        bool found = false;
15
16        while (queue.Count > 0 && !found)
17        {
18            int levelSize = queue.Count;
19
20            for (int i = 0; i < levelSize; i++)
21            {
22                string current = queue.Dequeue();
23
24                // Check whether current string is valid
25                if (IsValid(current))
26                {
27                    result.Add(current);
28                    found = true;
29                    continue;
30                }
31
32                // If valid strings have already been found,
33                // don't generate the next level.
34                if (found)
35                    continue;
36
37                // Remove one parenthesis
38                for (int j = 0; j < current.Length; j++)
39                {
40                    if (current[j] != '(' &&
41                        current[j] != ')')
42                    {
43                        continue;
44                    }
45
46                    string next =
47                        current.Substring(0, j) +
48                        current.Substring(j + 1);
49
50                    if (visited.Add(next))
51                    {
52                        queue.Enqueue(next);
53                    }
54                }
55            }
56        }
57
58        return result;
59    }
60
61    private bool IsValid(string s)
62    {
63        int balance = 0;
64
65        foreach (char c in s)
66        {
67            if (c == '(')
68            {
69                balance++;
70            }
71            else if (c == ')')
72            {
73                balance--;
74
75                if (balance < 0)
76                    return false;
77            }
78        }
79
80        return balance == 0;
81    }
82}