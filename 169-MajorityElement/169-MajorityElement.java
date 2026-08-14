// Last updated: 8/14/2026, 10:08:07 AM
class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int elem : nums){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }

       int maxCount = 0;
        int ans = 0;

        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            if (k.getValue() > maxCount) {
                maxCount = k.getValue();
                ans = k.getKey();
            }
        }

        return ans;
    }
}