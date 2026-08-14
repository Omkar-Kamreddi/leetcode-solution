// Last updated: 8/14/2026, 10:06:02 AM
class Solution {
    public int kthGrammar(int n, int k) {
        //Base condition
        if(n == 1 && k ==1){
            return 0;
        }
        //observation
        int mid = (int)Math.pow(2,n-1)/2;
        //hypothesis
        if(k <= mid){
            return kthGrammar(n-1,k);
        }else{
            return (kthGrammar(n,k-mid))==1? 0 : 1;
        }
    }
}