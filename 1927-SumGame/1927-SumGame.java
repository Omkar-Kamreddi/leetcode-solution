// Last updated: 8/23/2026, 3:41:07 PM
1class Solution {
2    public boolean sumGame(String num) {
3
4        //diff = rightSum - leftSum 
5        //target = 9 * (rightQ - leftQ)/2  searching for unmatch pair
6
7        int n = num.length();
8        int half = n / 2;
9
10        int leftSum = 0;
11        int rightSum = 0;
12
13        int leftQ = 0;
14        int rightQ = 0;
15
16        for (int i = 0; i < half; i++) {
17            if (num.charAt(i) == '?') {
18                leftQ++;
19            } else {
20                leftSum += num.charAt(i) - '0';
21            }
22        }
23
24        for (int i = half; i < n; i++) {
25            if (num.charAt(i) == '?') {
26                rightQ++;
27            } else {
28                rightSum += num.charAt(i) - '0';
29            }
30        }
31
32        int diff = leftSum - rightSum;
33
34        // int target = 9 * (rightQ - leftQ) / 2;
35        //by multiply both size 2
36        int target = 9 *(rightQ- leftQ);
37
38        return 2*diff != target;
39
40        
41    }
42}