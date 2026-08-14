// Last updated: 8/14/2026, 10:05:05 AM
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int count = 0;

        int maxRight = Integer.MIN_VALUE;

        for(int []interval : intervals){
            int r = interval[1];
            if(r > maxRight){
                count++;
                maxRight = r;
            }
        }
        return count;
    }
}