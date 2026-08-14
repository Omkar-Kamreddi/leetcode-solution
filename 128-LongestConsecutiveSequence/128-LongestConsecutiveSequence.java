// Last updated: 8/14/2026, 10:08:43 AM
class Solution {

    //Using HashSet -> Only start counting when a number is the start of a sequence

    public int longestConsecutive(int[] nums) {

    //Base case
    if(nums.length == 0){
        return 0;
    }

     HashSet<Integer> set = new HashSet<Integer>();
     int maxLen = 0;

     for(int n : nums){
        set.add(n);
     }

    for(int num : set){

        // start only if it's the beginning
        if(!set.contains(num-1)){

            int curr = num;
            int len = 1;

            // expand sequence
            while(set.contains(curr+1)){
                curr++;
                len++;
            }
            maxLen = Math.max(maxLen,len);
        }
    }
    return maxLen;
    }
}