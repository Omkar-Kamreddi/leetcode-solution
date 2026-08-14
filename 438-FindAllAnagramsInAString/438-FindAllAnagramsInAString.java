// Last updated: 8/14/2026, 10:06:53 AM
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<Integer>();

        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        if(s.length() < p.length())
            return res;
        
        //step 1) freq of p
        for(char c : p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int left = 0;
        //step 2) sliding window
        for(int right = 0; right<s.length(); right++){

            char r = s.charAt(right);
            window.put(r,window.getOrDefault(r,0)+1);

            //maintain window size
            if(right - left +1 > p.length()){
                char l = s.charAt(left);
                //undo
                window.put(l,window.get(l)-1);

                if(window.get(l) == 0){
                    //clean map
                    window.remove(l);
                }
                left++;
            }

            if(window.equals(pMap)){
                res.add(left);
            }

        }
        return res;
    }
}