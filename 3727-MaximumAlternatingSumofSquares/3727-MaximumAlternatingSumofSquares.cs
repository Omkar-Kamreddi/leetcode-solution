// Last updated: 10/19/2026, 9:42:52 PM
1public class Solution {
2
3    // IComparer(i) -> .Compare(T a,T b)
4
5    // For array of n length : 
6        //1) +ve position : n/2
7        //2) -ve position : n/2
8
9    //We don't need to generate every possible rearrangement.
10    //We only need to sort the numbers by their absolute values.
11
12    public long MaxAlternatingSum(int[] nums) {
13        //1) Sort by absolute value in ascending order.
14        Array.Sort(nums,(a,b)=>Math.Abs((long)a).CompareTo(Math.Abs((long)b)));
15        //2) Identify the negative and positive groups.
16        long score = 0;
17        int n = nums.Length;
18        int negNum = n/2;
19        //3) calculate the result
20        for(int i=0; i<n; i++){
21            long sq = (long)nums[i] * nums[i];
22
23            if(i < negNum){
24                score -= sq;
25            }else{
26                score += sq;
27            }
28        }   
29
30        return score;
31    }
32}
33
34// NOte : negativeCount = n / 2 tells us how many of the smallest squared values to subtract. All remaining squared values are added.