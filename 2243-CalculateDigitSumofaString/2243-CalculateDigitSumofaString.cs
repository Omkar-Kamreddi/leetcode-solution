// Last updated: 11/16/2026, 9:06:18 PM
1
2
3public class Solution {
4    public string DigitSum(string s, int k) {
5
6        while(s.Length > k){
7
8            var next = new StringBuilder();
9
10            for(int start = 0; start<s.Length; start+=k){
11                int end = Math.Min(start+k,s.Length);
12                int sum = 0;
13
14                for(int i = start; i<end; i++){
15                    sum+=s[i] - '0';
16                }
17                next.Append(sum);
18            }
19            s = next.ToString();
20
21        }
22        return s;
23    }
24}