// Last updated: 8/14/2026, 10:07:55 AM
class Solution {

    public void reverseArr(int arr[],int i , int k){

        int j = k-1;

        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArr(nums,0,nums.length);
        reverseArr(nums,0,k);
        reverseArr(nums,k,nums.length);
    }
}