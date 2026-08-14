// Last updated: 8/14/2026, 10:07:19 AM
class Solution {

    int t[][];

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        t = new int[n][n+1];

        for(int row[] : t){
            Arrays.fill(row,-1);
        }

        return solve(0,-1,nums);        
    }

    public int solve(int index,int prev,int []nums){

        //BC
        if(index == nums.length)
            return 0;

        //Check up
        if(t[index][prev+1] != -1)
            return t[index][prev+1];
        
        //Skip
        int notTake = solve(index+1,prev,nums);

        //take 
        int take = 0;

        if(prev == -1 || nums[index] > nums[prev]){
            //now prev = curr
            take = 1 + solve(index+1,index,nums);
        }

        return t[index][prev+1] = Math.max(take,notTake);

    }

}