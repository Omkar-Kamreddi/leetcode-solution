// Last updated: 8/14/2026, 9:57:45 AM
class Solution {
    public int maxProduct(int n) {
        int arr[] = digitArr(n);

        if(arr.length == 2){
            return arr[0]*arr[1];
        }else{
            int res = 0;
            for(int i=0; i<arr.length; i++){
                for(int j = i+1; j<arr.length; j++){
                    res = Math.max(res,arr[i]*arr[j]);
                }
            }
            return res;
        }

    }

    public int[] digitArr(int num){

        List<Integer> temp = new ArrayList<>();

        while(num!= 0){
            int digit = num%10;
            temp.add(digit);
            num /=10;
        }

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}