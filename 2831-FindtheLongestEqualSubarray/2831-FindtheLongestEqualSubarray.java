// Last updated: 8/21/2026, 5:57:50 PM
1class Solution {
2    public int longestEqualSubarray(List<Integer> nums, int k) {
3        
4        Map<Integer,List<Integer>> pos = new HashMap<>();
5
6        for(int i=0; i<nums.size(); i++){
7            pos.computeIfAbsent(nums.get(i),x -> new ArrayList<>()).add(i);
8        }
9
10        int ans = 0;
11        
12
13        for(List<Integer> list : pos.values()){
14
15            int left = 0;
16            int remainK = k;
17
18            for(int right = 0; right<list.size(); right++){
19                
20                if (right > 0) {
21                    remainK -=
22                        list.get(right) - list.get(right - 1) - 1;
23                }
24
25                while(remainK < 0){
26                    //rest k 
27                    remainK += list.get(left + 1) - list.get(left) - 1;
28
29                    left++;
30                }
31
32                ans = Math.max(ans,right - left + 1);
33            }
34        }
35        return ans;
36    }
37}