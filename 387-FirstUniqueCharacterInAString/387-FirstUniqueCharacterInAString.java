// Last updated: 8/14/2026, 10:07:03 AM
class Solution {
    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1); //inc by 1
            }else{
                //first time 
                map.put(ch,1);
            }
        }

        for(int i=0; i< s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}