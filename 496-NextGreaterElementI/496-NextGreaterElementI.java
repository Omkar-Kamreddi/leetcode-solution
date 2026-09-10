// Last updated: 9/10/2026, 7:13:40 PM
1class Solution {
2    int nextGreater[];
3    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
4        int n = nums2.length;
5        nextGreater = new int[n];
6        Arrays.fill(nextGreater, -1);
7
8        calculateNextGreater(nums2,n);
9
10        int ans[] = new int[nums1.length];
11        int idx = 0;
12        //Process nums1 array
13        for(int num : nums1){
14            for(int i=0; i<n; i++){
15                if(nums2[i] == num){
16                    ans[idx++] = nextGreater[i];
17                    break;
18                }
19            }
20        }
21
22        return ans;
23    }
24    public void calculateNextGreater(int arr[],int n){
25        Stack<Integer> stack = new Stack<>(); 
26        
27        for(int i=n-1; i>=0; i--){
28            
29            //Remove useLess Element
30            while(!stack.isEmpty() && stack.peek() <= arr[i]){
31                stack.pop();
32            }
33            
34            if(!stack.isEmpty()){
35                //stack top -> candidate answer
36                nextGreater[i] = stack.peek();
37            }
38            
39            //Push current element
40            stack.push(arr[i]);
41        }		
42    }
43}