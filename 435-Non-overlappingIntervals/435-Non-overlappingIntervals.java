// Last updated: 8/20/2026, 7:07:20 PM
1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3        
4        //Step 1) Sort by ending time
5        Arrays.sort(intervals,(a,b)->a[1] - b[1]);
6
7        int ans = 0;
8        int lastEnd = intervals[0][1];
9
10        for(int i= 1; i<intervals.length; i++){
11            if(intervals[i][0]>=lastEnd){
12                //No Overlapping
13                lastEnd = intervals[i][1];
14            }else{
15                //Overlapping
16                ans++;
17            }
18        }
19        return ans;
20    }
21}