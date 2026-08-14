// Last updated: 8/14/2026, 10:08:31 AM
class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        Set<Map.Entry<Integer,Integer>> enteries = map.entrySet();
        int res = 0;

        for(Map.Entry<Integer,Integer> e : enteries){
            if(e.getValue() == 1){
                res =  e.getKey();
            }
        }
        return res;
    }
}