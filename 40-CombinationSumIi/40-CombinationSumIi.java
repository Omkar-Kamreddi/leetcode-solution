// Last updated: 8/14/2026, 10:10:42 AM
class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     List<Integer> temp = new ArrayList();
     Arrays.sort(candidates);
     solve(0,candidates,target,temp);   

     return result;
    }

    public void solve(int index,int[] candidates,int currTarget,List<Integer> temp){
        //Base case 
        if(currTarget == 0){
            result.add(new ArrayList(temp));
            return ;
        }

        if(currTarget < 0)
            return ;


        for (int i = index; i < candidates.length; i++) {

            if(i > index && candidates[i] == candidates[i-1])
                continue;

             if (candidates[i] > currTarget)
                    break;   // ✅ PRUNING (main fix)


            temp.add(candidates[i]);
            solve(i+1, candidates, currTarget - candidates[i], temp); // reuse allowed
            temp.remove(temp.size() - 1);
        }
        

    }
}