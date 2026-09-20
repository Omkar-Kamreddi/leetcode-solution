// Last updated: 9/20/2026, 7:08:05 PM
1class Solution {
2    public int reverseDegree(String s) {
3
4        int count = 1;
5        int sum = 0;
6        for(char ch : s.toCharArray()){
7            int idx = ch - 'a';
8
9            sum+= (26-idx)*count;
10            count++;
11        }
12        return sum;
13    }
14}