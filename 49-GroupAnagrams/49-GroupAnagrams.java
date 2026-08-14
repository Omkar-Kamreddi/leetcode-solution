// Last updated: 8/14/2026, 10:10:18 AM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(String s : strs){
            char temp[] = s.toCharArray();
            Arrays.sort(temp);

            String x = new String(temp);

            if(map.containsKey(x)){
                map.get(x).add(s);
            }else{
                map.put(x,new ArrayList<String>());
                map.get(x).add(s);
            }
        }

        List<List<String>> list = new ArrayList<List<String>>();

        Set<String> set = map.keySet();

        for(String s : set){
            list.add(map.get(s));
        }

        return list;
    }
}