// Last updated: 8/14/2026, 10:07:40 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hashSet = new HashSet<>();

        for(int i=0; i< nums.length; i++){

            if(!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }
            else{
                return true;
            }
        }

        return false;
    }
}