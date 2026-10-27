// Last updated: 10/27/2026, 9:43:27 PM
1
2public class Solution {
3    public string[] CreateGrid(int m, int n) {
4        string[] grid = new string[m];
5
6        for (int i = 0; i < m; i++) {
7            char[] row = new char[n];
8
9            for (int j = 0; j < n; j++) {
10                if (i == 0 || j == n - 1) {
11                    row[j] = '.';
12                } else {
13                    row[j] = '#';
14                }
15            }
16
17            grid[i] = new string(row);
18        }
19
20        return grid;
21    }
22}
23