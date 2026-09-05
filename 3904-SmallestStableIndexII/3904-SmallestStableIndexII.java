// Last updated: 9/5/2026, 1:31:00 PM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3
4        //
5        int n = nums.length;
6        int prefixMax[] = new int[n];
7        int suffixMin[] = new int[n];
8
9        //build prefix maximum
10        prefixMax[0] = nums[0];
11        for(int i=1; i<n; i++){
12            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);
13        }
14
15        //Build Suffix Minimum
16        suffixMin[n-1] = nums[n-1];
17
18        for(int i=n-2; i>=0; i--){
19            suffixMin[i] = Math.min(suffixMin[i+1],nums[i]);
20        } 
21
22
23        //logic
24        for(int i=0; i<n; i++){
25            int instability = prefixMax[i] - suffixMin[i];
26
27            if(instability <= k){
28                return i;
29            }
30        }
31        return -1;
32    }
33}