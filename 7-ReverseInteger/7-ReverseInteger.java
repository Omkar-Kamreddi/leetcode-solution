// Last updated: 8/14/2026, 10:12:05 AM
class Solution {
    public int reverse(int x) {

        if(x == 0)
            return 0;

        String str = Integer.toString(Math.abs(x));
        int sum = 0;
        for(int i= str.length()-1; i>=0; i--){
            int num = Integer.parseInt(str.charAt(i)+"");
            // Check overflow
            if (sum > Integer.MAX_VALUE / 10 || 
               (sum == Integer.MAX_VALUE / 10 && num > 7)) return 0;

            if (sum < Integer.MIN_VALUE / 10 || 
               (sum == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            sum = sum * 10 + num;
        }
        return (x < 0)?-sum:sum;
    }
}