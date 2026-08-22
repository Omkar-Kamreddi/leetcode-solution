// Last updated: 8/22/2026, 12:25:26 PM
1class Solution {
2    public int countGoodSubstrings(String s) {
3
4        int count = 0;
5
6        Set<Character> set = null;
7
8        for(int i=0; i<= s.length()-3; i++){
9            set = new HashSet<>(List.of(s.charAt(i), s.charAt(i + 1), s.charAt(i + 2)));
10
11            if(set.size() == 3){
12                count++;
13            }
14        }
15        return count;
16    }
17}