// Last updated: 8/14/2026, 10:06:34 AM
class Solution {
    public boolean detectCapitalUse(String word) {
        
        if(allUpper(word) || allLower(word) || titleCase(word)){
            return true;
        }else{
            return false;
        }
    }

    //helper methods
    private boolean allUpper(String s){
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                count++;
            }
        }
        if(count == s.length()){
            return true;
        }
        return false;
    }

    private boolean allLower(String s){
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                count++;
            }
        }
        if(count == s.length()){
            return true;
        }
        return false;
    }

    private boolean titleCase(String s){
        char ch = s.charAt(0);
        String restString = s.substring(1);
        if(Character.isUpperCase(ch) && allLower(restString)){
            return true;
        }
        return false;
    }


}