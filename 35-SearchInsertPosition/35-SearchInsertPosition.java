// Last updated: 8/14/2026, 10:10:54 AM
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        //binary search approach
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid]< target){
                low = mid + 1;
            }
        }
        //When the loop ends, low will be the correct insertion position, so return low.
        return low;
    }
        
}