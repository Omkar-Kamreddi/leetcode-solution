// Last updated: 10/19/2026, 9:19:36 PM
1public class Solution {
2    public IList<int> TargetIndices(int[] nums, int target) {
3        
4        Array.Sort(nums);
5
6        IList<int> list = new List<int>();
7
8        for(int i=0; i<nums.Length; i++){
9            if(nums[i] == target){
10                list.Add(i);
11            }
12        }
13
14        return list;
15    }
16}