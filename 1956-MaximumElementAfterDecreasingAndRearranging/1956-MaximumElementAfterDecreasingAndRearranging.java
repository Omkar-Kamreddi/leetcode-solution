// Last updated: 8/14/2026, 10:03:15 AM
class Solution {

    

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        //Sort the array
        Arrays.sort(arr);

        //First elem must be 1
        arr[0] = 1;

        //update remaining elements => //Greedy approach 
         for(int i=1; i<arr.length; i++){
            arr[i] = Math.min(arr[i],arr[i - 1]+1);
        }
        
        // return the maximum element
        return arr[arr.length - 1];
    }
}