// Last updated: 8/14/2026, 10:10:58 AM
class Solution {
    public int[] searchRange(int[] nums, int target){

        if(nums.length == 0){
            return new int[]{-1,-1};
        }else if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0,0};
            }else{
                return new int[]{-1,-1};
            }
        }

        //logic for first-index
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while( low < high){
            mid = low + (high - low)/2;

            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        if(nums[low] != target){
            return new int[]{-1,-1};
        }

        int arr[] = new int[2];
        arr[0] = low;
        //reset condition
        high = nums.length - 1;

        //logic two for 2nd index
        while(low < high){
            mid = low + (high-low)/2;

            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        arr[1] = (nums[low] == target) ? low : low - 1;


        return arr;

    }

}