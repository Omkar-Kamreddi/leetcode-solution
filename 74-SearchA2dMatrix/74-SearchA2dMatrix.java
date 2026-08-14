// Last updated: 8/14/2026, 10:09:34 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length,col = matrix[0].length;

        //Hypothetical convert the 2D array to 1D array
        int low = 0, high = (row*col)-1;

        while(low <= high){
            //calculate mid
            int mid = low+(high-low)/2;

            //to find row
            int left = mid/col;
            //to find col
            int right = mid%col;

            if(matrix[left][right] == target){
                return true;
            }else if(matrix[left][right] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }

        }
      return false;   
    }
    
}