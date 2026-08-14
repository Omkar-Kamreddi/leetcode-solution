// Last updated: 8/14/2026, 9:56:19 AM
class Solution {

    public int mirror(int n){

        int rev = 0, digit = 0;

        while(n!= 0){
            digit = n%10;
            rev = rev * 10 + digit;
            n/=10;
        }
        return rev;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n-mirror(n));
    }
}