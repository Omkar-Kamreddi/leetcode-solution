// Last updated: 8/20/2026, 10:10:24 PM
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3
4        int n = nums.length;
5
6        int []ans = new int[n];
7
8        //Prefix Sum
9        ans[0] = 1;
10
11        for(int i=1; i<n; i++){
12            ans[i] = ans[i-1] * nums[i-1];
13        }
14
15        //suffix sum
16        int suffix = 1;
17
18        for(int i = n - 1; i>=0; i--){
19            ans[i] = ans[i] * suffix;
20            suffix = suffix * nums[i];
21        }
22        return ans;        
23    }
24}