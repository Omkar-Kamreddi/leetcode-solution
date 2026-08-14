// Last updated: 8/14/2026, 10:01:28 AM
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            List<Integer> temp = separate(nums[i]);
            ans.addAll(temp);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> separate(int n){
        List<Integer> list = new ArrayList<>();

        if (n == 0) {
            list.add(0);
            return list;
        }


        while(n != 0){
            int digit = n % 10;
            // list.add(digit);
            list.add(0, digit);
            n /= 10;
        }

        return list;
    }



}