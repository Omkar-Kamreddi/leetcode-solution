// Last updated: 8/14/2026, 10:07:51 AM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        //base condition 
        if(s.length() != t.length())
            return false;

        HashMap<Character,Character> forward = new HashMap<>();
        HashMap<Character,Character> reverse = new HashMap<>();

        //forward mapping
        for(int i=0; i<s.length(); i++){
            if(!forward.containsKey(s.charAt(i))){
                forward.put(s.charAt(i),t.charAt(i));
            }else{
                //already mapped
                if(forward.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }

        //reverse mapping
        for(int i=t.length()-1; i>=0; i--){
            if(!reverse.containsKey(t.charAt(i))){
                reverse.put(t.charAt(i),s.charAt(i));
            }else{
                //already mapped
                if(reverse.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }
        }
        if(forward.size() != reverse.size()){
            return false;
        }
        
        return true;
    }
}