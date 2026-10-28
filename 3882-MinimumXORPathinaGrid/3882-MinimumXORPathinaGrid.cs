// Last updated: 10/28/2026, 11:34:55 PM
1public class Solution
2{
3    public int MinCost(int[][] grid)
4    {
5        int m = grid.Length;
6        int n = grid[0].Length;
7        const int States = 1024;
8
9        bool[][] dp = new bool[n][];
10
11        for (int j = 0; j < n; j++)
12        {
13            dp[j] = new bool[States];
14        }
15
16        for (int i = 0; i < m; i++)
17        {
18            for (int j = 0; j < n; j++)
19            {
20                int value = grid[i][j];
21                bool[] current = new bool[States];
22
23                if (i == 0 && j == 0)
24                {
25                    current[value] = true;
26                }
27                else
28                {
29                    for (int x = 0; x < States; x++)
30                    {
31                        bool fromAbove = i > 0 && dp[j][x];
32                        bool fromLeft = j > 0 && dp[j - 1][x];
33
34                        if (fromAbove || fromLeft)
35                        {
36                            current[x ^ value] = true;
37                        }
38                    }
39                }
40
41                // Replace the states from above with this cell's states.
42                dp[j] = current;
43            }
44        }
45
46        for (int x = 0; x < States; x++)
47        {
48            if (dp[n - 1][x])
49            {
50                return x;
51            }
52        }
53
54        return -1; // Unreachable: at least one valid path always exists.
55    }
56}