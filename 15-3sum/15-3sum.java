// Last updated: 8/14/2026, 10:11:42 AM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            //skip duplicate
            if(i > 0 && nums[i] == nums[i-1])
                continue;
    
            int left = i+1;
            int right = nums.length - 1;
            //find other two numbers
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    //find answer
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //skip duplicates left
                    while(left < right && nums[left] == nums[left+1]) 
                        left++;     

                    //skip duplicates from right
                    while(left < right && nums[right] == nums[right-1])
                        right--;
                    
                    left++;
                    right--;
                }
            }
        }
       return list;
    }
    
}