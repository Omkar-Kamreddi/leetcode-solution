// Last updated: 8/14/2026, 10:11:39 AM
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<nums.length -2; i++){
            //duplicate skip
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int left = i + 1;
            int right = nums.length -1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){
                    return sum; //perfect close
                }

                int diff = Math.abs(sum - target);

                if(diff < minDiff){
                    minDiff = diff;
                    closestSum = sum;
                }

                if(sum < target)
                    left++;
                else 
                    right--;
            }
        }
        return closestSum;
        
    }
}