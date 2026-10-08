// Last updated: 10/8/2026, 9:32:37 PM
1public class Solution {
2    public string RemoveOuterParentheses(string s) {
3
4        int balance = 0;
5        StringBuilder res = new StringBuilder("");
6
7
8        foreach(char ch in s){
9
10            if(ch == '('){
11
12                if(balance > 0){
13                    res.Append(ch);
14                }
15
16                balance++;
17            }else{
18                balance--;
19
20                if(balance > 0){
21                    res.Append(ch);
22                }
23            }
24
25        }
26        return res.ToString();
27    }
28}