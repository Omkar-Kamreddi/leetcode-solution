// Last updated: 8/14/2026, 9:56:09 AM
class Solution {
    public long gcdSum(int[] nums) {

        int n = nums.length;

        int prefixGcd[] = new int[n];

        int maxSoFar = 0;
        for(int i=0; i<n; i++){
            maxSoFar = Math.max(maxSoFar,nums[i]);
            prefixGcd[i] = gcd(nums[i],maxSoFar);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int left =0;
        int right = n - 1;

        while(left < right){

            sum += gcd(prefixGcd[left],prefixGcd[right]);

            left++;
            right--;
        }
        return sum;
    }

    public int gcd(int a,int b){
        if(a == 0)
            return b;
        
        return gcd(b%a, a);
    }
}