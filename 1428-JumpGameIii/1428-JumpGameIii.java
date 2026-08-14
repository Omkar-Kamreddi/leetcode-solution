// Last updated: 8/14/2026, 10:04:42 AM
class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start);
    }

    public boolean dfs(int arr[], int i){

        //check 
        if (i < 0 || i >= arr.length || arr[i] < 0)
            return false;

        //base case
        if(arr[i] == 0)
            return true;

        //visited
        arr[i] *= -1;

        //Explore choices
        boolean a = dfs(arr,i+arr[i]);
        boolean b = dfs(arr,i-arr[i]);

        return a || b;
    }
}