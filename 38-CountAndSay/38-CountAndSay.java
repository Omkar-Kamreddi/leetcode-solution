// Last updated: 8/14/2026, 10:10:46 AM
class Solution {
    public String countAndSay(int n) {

        String ans = "1";

        for(int k = 2; k<= n ; k++){

            StringBuilder temp = new StringBuilder("");
            int count = 1;

            //Logic
            for(int i = 1; i <ans.length(); i++){
                if(ans.charAt(i) == ans.charAt(i-1)){
                    count++;
                }else{
                    temp.append(count);
                    temp.append(ans.charAt(i-1));
                    //revert change
                    count = 1;
                }
            }

            // add last group
            temp.append(count);
            temp.append(ans.charAt(ans.length()-1));

            ans = temp.toString();

        }
        return ans;
    }
}