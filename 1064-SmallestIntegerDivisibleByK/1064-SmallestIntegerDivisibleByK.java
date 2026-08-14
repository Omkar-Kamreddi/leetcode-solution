// Last updated: 8/14/2026, 10:05:26 AM
class Solution {
    public int smallestRepunitDivByK(int k) {

        //If k is factor of 2 or 5 -> imposible
        if(k%2 == 0 || k%5 ==0)
            return -1;
        
        // At most k iterations (pigeonhole principle)
        int remainder = 0;

        for(int len = 1; len<k+1; len++){
            remainder = (remainder*10 + 1) %k;

            if(remainder == 0)
                return len;
        }
        return -1;
    }
}