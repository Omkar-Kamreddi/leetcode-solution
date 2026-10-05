// Last updated: 10/5/2026, 9:17:37 PM
1public class Solution {
2    public int ScoreOfParentheses(string s) {
3        int score =0;
4        int depth = 0;
5        for(int i=0; i<s.Length; i++){
6            if(s[i] == '('){
7                depth++;
8
9            }else{
10                //found ()
11                if(s[i-1] == '('){
12                    score += 1 << (depth - 1);
13                }
14                depth--;
15            }
16        }
17        return score;
18    }
19}