// Last updated: 8/14/2026, 9:57:05 AM
class Solution {
    public int gcdOfOddEvenSums(int n) {

        int sumOdd = n*n;
        int sumEven = n*(n+1);

        return gcd(sumOdd,sumEven);
    }

    public int gcd(int a,int b){
        if(a == 0)
            return b;
        
        return gcd(b%a,a);
    }
}