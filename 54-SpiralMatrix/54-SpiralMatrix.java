// Last updated: 8/14/2026, 10:10:05 AM
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        List<Integer> ans = new ArrayList<Integer>();

        while(top <= bottom && left <= right){

            //right-> 
            for(int j = left; j<= right; j++){
                ans.add(matrix[top][j]);
            }
            top++;
            //bottom->
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            //left->
            if(top <= bottom){
                for(int j = right; j>= left; j--){
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }
            //top->
            if(left <= right)
            {
                for(int i = bottom; i>= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }


        }
        // return ans.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}