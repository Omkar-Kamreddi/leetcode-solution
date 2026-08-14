// Last updated: 8/14/2026, 10:08:09 AM
class Solution {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length -1;

        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] < nums[high]){
                high = mid;
            }
            else if(nums[mid] > nums[high]){
                low = mid+1;
            }else if(nums[mid] == nums[high]){
                //duplicate case;
                high--;
            }
        }   
        
        if(nums[low] == nums[high])
            return nums[low];
        
        return 0;
    }
}