// Last updated: 8/14/2026, 9:58:45 AM
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        //Step 1) create graph
        List<Integer> graph[] = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int []pair : invocations){
            graph[pair[0]].add(pair[1]);
        }
        
        //Step 2) find all suspicious using dfs
        boolean []suspicious = new boolean[n];
        Arrays.fill(suspicious,false);

        dfs(k,graph,suspicious);

        //Step 3) check no method outside the group invokes any methods within it.
        List<Integer> res = new ArrayList<>();

        for(int []pair : invocations){

            int first = pair[0];
            int second = pair[1];
            
            if(!suspicious[first] && suspicious[second]){
                //can't remove any thing
                
                for(int i=0; i<n; i++){
                    res.add(i);
                }

                return res;
            }

        }

        //We can remove suspicious
        for(int i=0; i<n; i++){
            if(!suspicious[i]){
                res.add(i);
            }
        }
        return res;
    }

    public void dfs(int node,List<Integer> []graph,boolean []suspicious){
        
        suspicious[node] = true;

        for(int next : graph[node]){
            if(!suspicious[next]){
                dfs(next,graph,suspicious);
            }
        }

    }
}