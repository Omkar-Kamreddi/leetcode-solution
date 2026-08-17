// Last updated: 8/17/2026, 9:48:47 PM
1class NumArray {
2
3    private int prefixSum[];
4
5    public NumArray(int[] nums){
6        int n = nums.length;
7
8        prefixSum = new int[n+1];
9
10        for(int i=0; i<n;i++){
11            prefixSum[i+1] = prefixSum[i] + nums[i];
12        }
13    }
14    
15    public int sumRange(int left, int right) {
16        return prefixSum[right+1] - prefixSum[left];
17    }
18}
19
20/**
21 * Your NumArray object will be instantiated and called as such:
22 * NumArray obj = new NumArray(nums);
23 * int param_1 = obj.sumRange(left,right);
24 */