// Last updated: 8/14/2026, 10:09:59 AM
class Solution {
    public int[][] merge(int[][] intervals) {

        //case 1 :
        if(intervals.length == 0)
            return new int[0][0];

        //step 1 : sort by start elem
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> result = new ArrayList<>();

        int curr[] = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int []next = intervals[i];

            //overlap 
            if(next[0] <= curr[1]){
                curr[1] = Math.max(curr[1],next[1]);
            }else{
                result.add(curr);
                //now my curr is next pair
                curr = next;
            }
        }
        
        //add last pair
        result.add(curr);

        return result.toArray(new int[result.size()][]);
    }
}