// Last updated: 8/14/2026, 10:06:04 AM
class Solution {
    //hepler method 
    public int binarySearch(int arr[],int target, int st, int end){

        //base case
        if(st<=end){
            int mid = st+(end - st)/2;

            if( arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                //search in second half
                return binarySearch(arr,target,mid+1,end);
            }else{
                //search in first half
                return binarySearch(arr,target,st,mid-1);
            }
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        return binarySearch(arr,target,0,arr.length-1);
    }
}