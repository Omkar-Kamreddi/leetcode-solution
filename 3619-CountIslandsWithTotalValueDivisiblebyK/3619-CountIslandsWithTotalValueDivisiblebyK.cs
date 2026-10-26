// Last updated: 10/26/2026, 9:33:16 PM
1
2public class Solution
3{
4    public int CountIslands(int[][] grid, int k)
5    {
6        int m = grid.Length;
7        int n = grid[0].Length;
8
9        int count = 0;
10
11        int[] dr = { -1, 1, 0, 0 };
12        int[] dc = { 0, 0, -1, 1 };
13
14        for (int r = 0; r < m; r++)
15        {
16            for (int c = 0; c < n; c++)
17            {
18                // Water or already visited land
19                if (grid[r][c] == 0)
20                    continue;
21
22                long sum = grid[r][c];
23
24                Stack<(int row, int col)> stack = new();
25
26                stack.Push((r, c));
27
28                // Mark as visited
29                grid[r][c] = 0;
30
31                while (stack.Count > 0)
32                {
33                    var (row, col) = stack.Pop();
34
35                    // Explore four directions
36                    for (int d = 0; d < 4; d++)
37                    {
38                        int nr = row + dr[d];
39                        int nc = col + dc[d];
40
41                        // Check grid boundaries
42                        if (nr < 0 || nr >= m ||
43                            nc < 0 || nc >= n)
44                        {
45                            continue;
46                        }
47
48                        // Skip water or visited cells
49                        if (grid[nr][nc] == 0)
50                            continue;
51
52                        // Include cell value in island sum
53                        sum += grid[nr][nc];
54
55                        // Mark visited before pushing
56                        grid[nr][nc] = 0;
57
58                        stack.Push((nr, nc));
59                    }
60                }
61
62                // Evaluate the complete island
63                if (sum % k == 0)
64                    count++;
65            }
66        }
67
68        return count;
69    }
70}
71