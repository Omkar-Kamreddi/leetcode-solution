// Last updated: 8/16/2026, 10:04:03 PM
1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int[] cnt = new int[3];
4
5        for (int stone : stones) {
6            cnt[stone % 3]++;
7        }
8
9        int zero = cnt[0];
10        int one = cnt[1];
11        int two = cnt[2];
12
13        // Stones divisible by 3 act like "passes".
14        if (zero % 2 == 0) {
15            // Alice can win if both 1-mod-3 and 2-mod-3 stones exist.
16            return one > 0 && two > 0;
17        }
18
19        // Odd number of 0-mod-3 stones.
20        // Alice wins only if one residue type dominates by more than 2.
21        return Math.abs(one - two) > 2;
22    }
23}