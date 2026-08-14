// Last updated: 8/14/2026, 10:12:23 AM
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i<nums.length; i++){
            int res = target - nums[i];

            if(map.containsKey(res)){
                return new int[]{map.get(res),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}