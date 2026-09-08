// Last updated: 9/8/2026, 7:09:51 PM
1class Solution {
2    public int countCommas(int n) { 
3        return Math.max(0,n-999);
4    }
5}
6
7//Observation
8
9//1       → 0
10//99      → 0
11//999     → 0
12//1000    → 1
13//9999    → 1
14//99999   → 1
15//100000  → 1  : 10^5