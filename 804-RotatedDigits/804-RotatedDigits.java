// Last updated: 8/14/2026, 10:05:59 AM
//BRUTE FORCE :


// class Solution {

//     public int rotatedDigits(int n) {

//         int count = 0;

//         for(int i=1; i<=n; i++){
//             if(isGood(i)){
//                 count++;
//             }
//         }
//         return count;
//     }

//     public boolean isGood(int num){
//         boolean flag = false;

//         while(num > 0 ){
//             int digit = num % 10;

//             if(digit == 3 || digit == 4 || digit == 7){
//                 return false;
//             }

//             if(digit == 2 || digit == 5 || digit == 6 || digit == 8){
//                 flag = true;
//             }
//             num = num / 10;
//         }
//         return flag;
//     }   
// }

class Solution{
    public int rotatedDigits(int n) {

        int dp[] = new int[n+1];
        int count = 0;

        Arrays.fill(dp,0);

        for(int i=0; i<=n; i++){

            if(i < 10){

                if(i == 0 || i == 1 || i == 8){
                    dp[i] = 0;
                }else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 1;
                    count++;
                }else{
                    dp[i] = -1;
                }

            }else{

                int last = i % 10;
                int prev = i / 10;

                if(dp[prev] == -1 || dp[last] == -1){
                    dp[i] = -1;
                }
                else if(dp[prev] == 1 || dp[last] == 1){
                    dp[i] = 1;
                    count++;
                }else{
                    dp[i] = 0;
                }
            }
        }
        return count;
    }
}