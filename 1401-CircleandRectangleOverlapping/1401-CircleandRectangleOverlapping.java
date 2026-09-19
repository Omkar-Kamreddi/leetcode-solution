// Last updated: 9/19/2026, 8:01:33 PM
1class Solution {
2    public boolean checkOverlap(
3            int radius,
4            int xCenter,
5            int yCenter,
6            int x1,
7            int y1,
8            int x2,
9            int y2) {
10
11        // Closest point of rectangle to circle center
12        int closestX = Math.max(x1, Math.min(xCenter, x2));
13        int closestY = Math.max(y1, Math.min(yCenter, y2));
14
15        // Difference between circle center and closest point
16        int dx = xCenter - closestX;
17        int dy = yCenter - closestY;
18
19        // Compare squared distances
20        return dx * dx + dy * dy <= radius * radius;
21    }
22}