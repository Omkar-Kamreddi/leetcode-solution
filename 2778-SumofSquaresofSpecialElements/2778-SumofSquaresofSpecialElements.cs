// Last updated: 10/11/2026, 9:05:31 PM
1public class Solution {
2    public int SumOfSquares(int[] nums) {
3        int n = nums.Length;
4        int res = 0;
5        for(int i=1; i<=n; i++){
6            if(n%i == 0){
7                res += (nums[i-1]*nums[i-1]);
8            }
9        }
10        return res;
11    }
12}