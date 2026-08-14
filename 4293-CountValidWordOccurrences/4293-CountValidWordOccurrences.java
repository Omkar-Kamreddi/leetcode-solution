// Last updated: 8/14/2026, 9:56:14 AM
class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {

        HashMap<String,Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(String str : chunks){
            sb.append(str);
        }

        String s = sb.toString();

        int n = s.length();

        StringBuilder word = new StringBuilder();

        for(int i =0; i<n; i++){
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)){
                word.append(ch);
            }
            else if(ch == '-' && word.length() > 0 && i+1 < n && Character.isLowerCase(s.charAt(i+1))){
                word.append(ch);
            }else{
                if(word.length() > 0){
                    String w = word.toString();

                    if(w.charAt(w.length()-1) == '-'){
                        w = w.substring(0,w.length()-1);
                    }
                    if(!w.isEmpty()){
                        map.put(w,map.getOrDefault(w,0)+1);
                    }
                    word.setLength(0);
                }
            }
        }

        if(word.length() > 0){
            String w = word.toString();

            if(w.charAt(w.length()-1) == '-'){
                w = w.substring(0,w.length()-1);
            }

            if(!w.isEmpty()){
                map.put(w,map.getOrDefault(w,0)+1);
            }
        }
        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            ans[i] = map.getOrDefault(queries[i],0);
        }
        return ans;
    }
}