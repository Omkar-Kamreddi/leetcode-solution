// Last updated: 8/14/2026, 10:02:05 AM
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int left =0, right = n - 1;

        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                ans[left++] = nums[i];
            }
        }

        for(int i= n-1; i>=0; i--){
            if(nums[i] > pivot){
                ans[right--] = nums[i];
            }
        }
        
        //store the pivot 
        while(left <= right){
            ans[left++] = pivot;
        }

        return ans;
    }
}