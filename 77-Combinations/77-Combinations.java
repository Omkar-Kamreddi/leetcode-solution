// Last updated: 9/6/2026, 8:26:10 PM
1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        
4        List<List<Integer>> res = new ArrayList<>();
5
6        List<Integer> curr = new ArrayList<>();
7
8        generateCombination(1,n,k,curr,res);
9
10        return res;
11    }
12
13    public void generateCombination(int start,int n,int k,List<Integer> curr, List<List<Integer>> res){
14        
15        //Base case
16        if(curr.size() == k){
17            res.add(new ArrayList<>(curr));
18        }
19
20        //Recursive choices
21        for(int i=start; i<=n; i++){
22
23            //choose
24            curr.add(i);
25
26            //Explore
27            generateCombination(i+1,n,k,curr,res);
28
29            //Undo
30            curr.remove(curr.size()-1);
31        }
32
33    }
34}