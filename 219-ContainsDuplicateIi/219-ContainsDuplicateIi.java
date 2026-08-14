// Last updated: 8/14/2026, 10:07:36 AM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],i);
            }else{
                if(nums[hashMap.get(nums[i])] == nums[i] && Math.abs(hashMap.get(nums[i])-i) <= k){
                    return true;
                }else{
                    hashMap.put(nums[i],i);
                }
            }
        }
        return false;
    }
}