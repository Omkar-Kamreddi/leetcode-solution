// Last updated: 8/18/2026, 4:50:57 PM
1class Solution {
2
3    public int largestInteger(int[] nums, int k) {
4
5        int count[] = new int[51];
6        int num = 0;
7
8        for(int i=0; i<= nums.length-k; i++){
9
10            //trace
11            boolean seen[] = new boolean[51];
12
13            for(int j = i; j<i+k; j++){
14                num = nums[j];
15
16                if(!seen[num]){
17                    seen[num] = true;
18                    count[num]++;
19                }
20            }
21        }
22
23        for(int n=50; n>=0; n--){
24            if(count[n] == 1){
25                return n;
26            }
27        }
28        
29        return -1;
30    }
31}