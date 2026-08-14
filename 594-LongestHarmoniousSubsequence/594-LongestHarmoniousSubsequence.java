// Last updated: 8/14/2026, 10:06:26 AM
class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        int maxLen = 0;

        //check pairs (x, x+1)
        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                int len = map.get(key) + map.get(key+1);

                maxLen = Math.max(maxLen,len);
            }
        }
        
        return maxLen;
    }
}