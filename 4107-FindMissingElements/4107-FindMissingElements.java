// Last updated: 8/14/2026, 9:56:45 AM
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        List<Integer> res = new ArrayList();

        int min = nums[0];
        int max = nums[1];

        Set<Integer> set = new HashSet();

        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
            set.add(i);
        }

        

        for(int i=min; i<=max; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}