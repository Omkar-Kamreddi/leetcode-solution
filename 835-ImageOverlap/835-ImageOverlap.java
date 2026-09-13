// Last updated: 9/13/2026, 9:20:00 PM
1import java.util.*;
2
3class Solution {
4
5    public int largestOverlap(int[][] img1, int[][] img2) {
6
7        int n = img1.length;
8
9        // Store coordinates of 1s in both images
10        List<int[]> points1 = new ArrayList<>();
11        List<int[]> points2 = new ArrayList<>();
12
13        // Extract 1s from img1
14        for (int r = 0; r < n; r++) {
15            for (int c = 0; c < n; c++) {
16
17                if (img1[r][c] == 1) {
18                    points1.add(new int[]{r, c});
19                }
20            }
21        }
22
23        // Extract 1s from img2
24        for (int r = 0; r < n; r++) {
25            for (int c = 0; c < n; c++) {
26
27                if (img2[r][c] == 1) {
28                    points2.add(new int[]{r, c});
29                }
30            }
31        }
32
33        // Store frequency of each translation
34        Map<String, Integer> frequency = new HashMap<>();
35
36        int maxOverlap = 0;
37
38        // Try every pair of 1-points
39        for (int[] p1 : points1) {
40
41            int r1 = p1[0];
42            int c1 = p1[1];
43
44            for (int[] p2 : points2) {
45
46                int r2 = p2[0];
47                int c2 = p2[1];
48
49                // Translation required to move p1 -> p2
50                int dr = r2 - r1;
51                int dc = c2 - c1;
52
53                String key = dr + "," + dc;
54
55                int count = frequency.getOrDefault(key, 0) + 1;
56
57                frequency.put(key, count);
58
59                maxOverlap = Math.max(maxOverlap, count);
60            }
61        }
62
63        return maxOverlap;
64    }
65}