// Last updated: 8/14/2026, 10:07:31 AM
class Solution {
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;

        int arr[] = {2,3,5};

        for(int num : arr){
            while(n%num == 0){
                n/=num;
            }
        }
        return n == 1;
    }
}