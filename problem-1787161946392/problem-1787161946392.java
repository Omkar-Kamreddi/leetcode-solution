// Last updated: 8/19/2026, 11:22:26 PM
1class Solution {
2
3    public String addStrings(String num1, String num2) {
4
5        int i = num1.length() - 1;
6        int j = num2.length() - 1;
7
8        int carry = 0;
9
10        StringBuilder result = new StringBuilder();
11
12        while (i >= 0 || j >= 0 || carry != 0) {
13
14            int digit1 = 0;
15            int digit2 = 0;
16
17            if (i >= 0) {
18                digit1 = num1.charAt(i) - '0';
19                i--;
20            }
21
22            if (j >= 0) {
23                digit2 = num2.charAt(j) - '0';
24                j--;
25            }
26
27            int sum = digit1 + digit2 + carry;
28
29            result.append(sum % 10);
30
31            carry = sum / 10;
32        }
33
34        return result.reverse().toString();
35    }
36}