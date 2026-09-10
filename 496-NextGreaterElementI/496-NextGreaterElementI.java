// Last updated: 9/10/2026, 8:19:17 PM
1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n = nums.length;
4        int ans[] = new int[n];
5        Arrays.fill(ans,-1);
6
7        Stack<Integer> stack = new Stack<>();
8
9        for(int i = 2*(n-1); i>=0; i--){
10
11            int curr = nums[i%n];
12
13            //Remove
14            while(!stack.isEmpty() && stack.peek() <= curr){
15                stack.pop();
16            }
17
18            //stack top -> Candidate ans
19            if(i < n && !stack.isEmpty()){
20                ans[i%n] = stack.peek();
21            }
22
23            stack.push(curr);
24        }
25        return ans;
26    }
27}