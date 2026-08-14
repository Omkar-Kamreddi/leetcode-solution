// Last updated: 8/14/2026, 10:10:38 AM
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        //rearrangement logic
        for(int i=0; i<n; i++){

            while(nums[i] > 0 && nums[i] <=n && nums[nums[i] -1]!= nums[i]){
                //swap it
                int corrIdx = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[corrIdx];
                nums[corrIdx] = temp;

            }

        }

        //find missing positive number
        for(int i=0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}