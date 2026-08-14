// Last updated: 8/14/2026, 10:01:49 AM
class Solution {

    public int getDiffCount(String query,String dict){
        int count = 0, i = 0;
        int n = query.length();

        while(i <= n){
            if(i<dict.length() && query.charAt(i) != dict.charAt(i)){
                count++;
            }
            i++;
        }
        return count;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> res = new ArrayList<String>();

        for(int i = 0; i < queries.length; i++){
            String q = queries[i];

            for(int j = 0; j < dictionary.length; j++){
                if(getDiffCount(q, dictionary[j]) <= 2){
                    res.add(q);
                    break; // stop once match found
                }
            }
        }
        return res;
    }
}