// Last updated: 9/12/2026, 10:01:24 PM
1// class Solution {
2//     public int findLongestChain(int[][] pairs) {
3//         Arrays.sort(pairs,(a,b)->a[0]-b[0]);
4//         return findLongest(0,Integer.MIN_VALUE,pairs);
5//     }
6
7//     public int findLongest(int index,int prevEnd,int [][]pairs){
8
9//         //Base case
10//         if(index == pairs.length){
11//             return 0;
12//         }
13
14//         //Skip curr Pair
15//         int skip = findLongest(index+1,prevEnd,pairs);
16
17//         //Take Curr Pair if possible
18//         int take = 0;
19
20//         if(pairs[index][0]>prevEnd){
21//             take = 1+ findLongest(index+1,pairs[index][1],pairs);
22//         }
23
24//         return Math.max(skip,take);
25//     }
26// }
27
28
29import java.util.*;
30
31class Solution {
32
33    public int findLongestChain(int[][] pairs) {
34
35        Arrays.sort(pairs, (a, b) ->
36                Integer.compare(a[0], b[0]));
37
38        int n = pairs.length;
39
40        int[] dp = new int[n];
41        Arrays.fill(dp, 1);
42
43        int answer = 1;
44
45        for (int i = 0; i < n; i++) {
46
47            for (int j = 0; j < i; j++) {
48
49                if (pairs[j][1] < pairs[i][0]) {
50
51                    dp[i] = Math.max(
52                            dp[i],
53                            dp[j] + 1
54                    );
55                }
56            }
57
58            answer = Math.max(answer, dp[i]);
59        }
60
61        return answer;
62    }
63}