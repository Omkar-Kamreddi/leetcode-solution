// Last updated: 8/14/2026, 10:05:32 AM
class Solution {
    //Sliding window
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums,k) - atmostK(nums,k-1);
    }

    private int atmostK(int []nums,int k){

        //Base condition
        if(k<0)
            return 0;

        //Track 
        Map<Integer,Integer> map = new HashMap();

        int left =0;
        int ans = 0;
        int n = nums.length;

        
        for(int right = 0; right < n; right++){
            //Expanding
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size() > k){
                //Shrinking
                map.put(nums[left],map.get(nums[left])-1);

                if(map.get(nums[left] ) == 0){
                    map.remove(nums[left]);
                }

                left++;
            }

            //Key obeservation
            ans += (right - left + 1);

        }
        return ans;
    }
}