// Last updated: 8/14/2026, 10:00:01 AM
class Solution {
    public boolean isAcronym(List<String> words, String s) {

        if(s.length() != words.size())
            return false;

        Iterator<String> i = words.iterator();
        char arr[] = s.toCharArray();
        int index = 0;

        while(i.hasNext()){
            String word = i.next();
            
            if(word.charAt(0) != arr[index]){
                return false;
            }
           index++;

        }
        return true;
    }
}