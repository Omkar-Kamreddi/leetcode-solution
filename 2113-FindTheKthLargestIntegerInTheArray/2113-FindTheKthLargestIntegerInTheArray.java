// Last updated: 8/14/2026, 10:02:43 AM
class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums,(a,b)->{

            //not equal len
            if(a.length() != b.length()){
                return Integer.compare(b.length(),a.length());
            }

            //equal in len
            return b.compareTo(a);
        });

        return nums[k-1];
        
    }
}