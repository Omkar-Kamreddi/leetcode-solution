// Last updated: 9/7/2026, 9:20:27 PM
1// class Solution {
2//     public int distinctSubseqII(String s) {
3//         Set<String> set = new HashSet<>();
4
5//         generateSubseq(0,s,new StringBuilder(""),set);
6
7//         return set.size()-1;
8//     }
9
10//     //RECURSION 
11
12//     // public void generateSubseq(String s,int idx,String curr,Set<String> set){
13        
14//     //     //Base case
15//     //     if(idx == s.length()){
16//     //         set.add(curr);
17//     //         return;
18//     //     }
19        
20//     //     if(idx > s.length())    
21//     //         return ;
22
23//     //     //Not Take
24//     //     generateSubseq(s,idx+1,curr,set);
25//     //     //Take
26//     //     generateSubseq(s,idx+1,curr+s.charAt(idx),set);
27//     // }
28
29
30//     //RECURSION + BACKTRACKING
31//     public void generateSubseq(int start,String s,StringBuilder curr, Set<String> set){
32        
33//         set.add(curr.toString());
34
35//         boolean []used = new boolean[26];
36
37//         for(int i=start; i<s.length(); i++){
38//             int c = s.charAt(i) - 'a';
39
40//             //Same Character at this level -> duplicate
41//             if(used[c]){
42//                 continue;
43//             }
44
45//             used[c] = true;
46
47//             //Choose
48//             curr.append(s.charAt(i));
49
50//             //Explore
51//             generateSubseq(i+1,s,curr,set);
52
53//             //Undo
54//             curr.deleteCharAt(curr.length()-1);
55//         }
56//     }
57// }
58
59
60class Solution {
61
62    public int distinctSubseqII(String s) {
63
64        final long MOD = 1_000_000_007;
65
66        int n = s.length();
67
68        // dp[i] = number of distinct subsequences
69        // including empty subsequence using first i characters
70        long[] dp = new long[n + 1];
71
72        dp[0] = 1; // empty subsequence
73
74        int[] last = new int[26];
75
76        Arrays.fill(last, -1);
77
78        for (int i = 1; i <= n; i++) {
79
80            int c = s.charAt(i - 1) - 'a';
81
82            // Add current character to every existing subsequence
83            dp[i] = (2 * dp[i - 1]) % MOD;
84
85            // Remove duplicates caused by previous occurrence
86            if (last[c] != -1) {
87                dp[i] = (dp[i] - dp[last[c] - 1] + MOD) % MOD;
88            }
89
90            last[c] = i;
91        }
92
93        // Remove empty subsequence
94        return (int) ((dp[n] - 1 + MOD) % MOD);
95    }
96}