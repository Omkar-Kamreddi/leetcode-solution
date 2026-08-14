// Last updated: 8/14/2026, 9:58:33 AM
class Solution {
    public int smallestNumber(int n, int t) {

        if(digitSum(n,t)){
            return n;
        }
        

        while(true){
            n = n + 1;
            if(digitSum(n,t)){
                return n;
            }
        }
        
    }

    public boolean digitSum(int n,int t){
        int num = n;
        int prod = 1;

        while(num != 0){
            int digit = num % 10;
            prod *= digit;
            num /=10;
        }

        return prod%t == 0;
    }
}