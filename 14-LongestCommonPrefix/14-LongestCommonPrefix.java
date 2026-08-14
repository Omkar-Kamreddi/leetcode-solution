// Last updated: 8/14/2026, 10:11:45 AM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length ==0 || strs == null)
        {
            return "";
        }
        
        //suppose initial prefix string is strs[0]

        String prefix = strs[0];

        for(int i=1; i<strs.length; i++){

            while(strs[i].indexOf(prefix) != 0){

                prefix = prefix.substring(0,prefix.length() -1 );

                if(prefix.isEmpty()){
                    return "";
                }
            }

        }

        return prefix;


    }
}