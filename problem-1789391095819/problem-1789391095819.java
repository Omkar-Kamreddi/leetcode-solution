// Last updated: 9/14/2026, 6:34:55 PM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        //[x1, y1, x2, y2]
4        boolean xOverlap =
5            Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
6
7        boolean yOverlap =
8            Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
9
10        return xOverlap && yOverlap;
11    }
12}