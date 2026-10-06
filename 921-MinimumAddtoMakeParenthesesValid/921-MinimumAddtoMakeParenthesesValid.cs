// Last updated: 10/6/2026, 8:28:12 PM
1public class Solution {
2    public int MinAddToMakeValid(string s) {
3
4        int balance = 0;
5        int addition = 0;
6
7        foreach(char ch in s){
8
9            if(ch == '('){
10                balance++;
11            }else{
12                if(balance> 0){
13                    balance--;
14                }else{
15                    addition++;
16                }
17            }
18
19        }
20        return balance+addition;
21    }
22}