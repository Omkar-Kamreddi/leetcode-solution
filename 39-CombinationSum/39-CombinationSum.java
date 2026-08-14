// Last updated: 8/14/2026, 10:10:45 AM
class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<Integer>();
        solve(0,candidates,target,temp);

        return result;
    }

    public void solve(int index,int []candidates,int remainTarget,List<Integer> temp){

        //Base case 
        if(remainTarget == 0){
            result.add(new ArrayList(temp));
            return ;
        }

        //base case if invalid
        if(index == candidates.length || remainTarget < 0){
            return ;
        }

        //Choice 1: pick current element
        //indunction
        temp.add(candidates[index]);
        //hypothesis
        solve(index,candidates,remainTarget-candidates[index],temp);
        //backtrack
        temp.remove(temp.size()-1);

        //choice 2: skip current element
        solve(index+1,candidates,remainTarget,temp);
    }
}