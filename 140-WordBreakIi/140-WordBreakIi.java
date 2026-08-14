// Last updated: 8/14/2026, 10:08:25 AM
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        Map<Integer,List<String>> memory = new HashMap();

        return dfs(s,0,set,memory);
    }

    public List<String> dfs(String s,int index,Set<String> set,Map<Integer,List<String>> memory){

        //memoization
        if(memory.containsKey(index)){
            return memory.get(index);
        }

        List<String> temp = new ArrayList<>();

        //base case
        if(index == s.length()){
            temp.add("");
            return temp;
        }

        //Explore choices
        for(int i=index; i< s.length(); i++){

            String word = s.substring(index,i+1);

            // controlled recursion
            if(set.contains(word)){
                //explore further
                List<String> nextList = dfs(s,i+1,set,memory);

                //backtrack 
                for(String next : nextList){
                    if(next.isEmpty()){
                        temp.add(word); //last word no space
                    }else{
                        temp.add(word+" "+next); //build sentence
                    }
                }
            }
        }
        memory.put(index,temp);

        return temp;
    }
}