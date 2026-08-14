// Last updated: 8/14/2026, 10:09:21 AM
class Solution {
    private Map<String,Boolean> dp = null;
    public boolean isScramble(String s1, String s2) {
        dp = new HashMap<>();

        return isScrambleStr(s1,s2,dp);
    }   

    public boolean isScrambleStr(String s1,String s2,Map<String,Boolean> dp){
        int n = s1.length();
        //base case
        if(s1.equals(s2))
            return true;

        int freq[] = new int[26];

        for(int i=0; i<n; i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(freq[i] != 0)
                return false;
        }   

        String key = s1.concat(s2);

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        for(int i=1; i<n; i++){
            
            boolean noSwap = isScrambleStr(s1.substring(0,i),s2.substring(0,i),dp) && isScrambleStr(s1.substring(i),s2.substring(i),dp);

            if(noSwap){
                dp.put(key,true);
                return true;
            }
                

            //both str must have same length
            boolean swap = isScrambleStr(s1.substring(0,i),s2.substring(n-i),dp) && isScrambleStr(s1.substring(i),s2.substring(0,n-i),dp);

            if(swap){
                dp.put(key,true);
                return true;
            }
                
        }

        dp.put(key,false);
        return false;
    }
}