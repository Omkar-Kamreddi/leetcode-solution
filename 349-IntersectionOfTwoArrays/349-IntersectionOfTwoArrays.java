// Last updated: 8/14/2026, 10:07:06 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> arr1 = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();

        for(int val:nums1){
            arr1.add(val);
        }

        for(int i:nums2){
            if(arr1.contains(i)){
                result.add(i);
            }
        }

        int res[] = new int[result.size()];

        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }

        return res;

    }
}