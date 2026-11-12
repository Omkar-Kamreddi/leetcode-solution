// Last updated: 11/12/2026, 9:46:28 PM
1public class Solution {
2    public int LongestMonotonicSubarray(int[] nums) {
3        int n = nums.Length;
4        int increasing = 1;
5        int decreasing = 1;
6        int longest = 1;
7
8        for(int i=1; i<n; i++){
9            if (nums[i] > nums[i - 1])
10            {
11                increasing++;
12                decreasing = 1;
13            }
14            else if (nums[i] < nums[i - 1])
15            {
16                decreasing++;
17                increasing = 1;
18            }
19            else
20            {
21                increasing = 1;
22                decreasing = 1;
23            }
24
25            longest = Math.Max(
26                longest,
27                Math.Max(increasing, decreasing)
28            );
29        }
30
31        return longest;
32        
33    }
34}