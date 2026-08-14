// Last updated: 8/14/2026, 9:56:54 AM
class Solution {
    public int totalWaviness(int num1, int num2) {

        int total = 0;

        for(int n = num1; n<= num2; n++){
            total += getWaviness(n);
        }

        return total;
    }

    private int getWaviness(int num){
        String s = String.valueOf(num);

        if(s.length() < 3){
            return 0;
        }

        int waviness = 0;

        for(int i=1; i<s.length()-1; i++){
            int left = s.charAt(i-1)-'o';
            int curr = s.charAt(i)-'o';
            int right = s.charAt(i+1) - 'o';

            if((curr > left && curr > right )|| (curr < left && curr < right)){
                waviness++;
            }
        }

        return waviness;
    }
}