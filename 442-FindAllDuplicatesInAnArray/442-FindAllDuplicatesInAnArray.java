// Last updated: 8/14/2026, 10:06:50 AM
class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        if(nums.length <= 1){
            return new ArrayList<Integer>();
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int elem : nums){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }

        List<Integer> res = new ArrayList<Integer>();

        for(Map.Entry<Integer,Integer> entery : map.entrySet()){
            if(entery.getValue() == 2){
                res.add(entery.getKey());
            }
        }
        return res;
    }
}