// Last updated: 9/28/2026, 9:24:26 PM
1class Solution {
2    public int maxDepth(String s) {
3
4        int depth = 0;
5        int maxDepth = 0;
6
7        for(char ch : s.toCharArray()){
8            if(ch == '('){
9                depth++;
10                maxDepth = Math.max(maxDepth,depth);
11            }else if(ch== ')'){
12                depth--;
13            }
14        }
15        return maxDepth;
16    }
17}