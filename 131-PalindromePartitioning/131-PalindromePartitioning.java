// Last updated: 8/14/2026, 10:08:40 AM
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        List<String> temp = new ArrayList<String>();
        solve(s,temp,0);

        return res;
    }

    public void solve(String s,List<String> temp,int index){

        //Base condition
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return ;
        }

        String pl_str = "";
        //Explore the choices
        for(int i = index; i<s.length(); i++){
            pl_str += s.charAt(i);
            if(isPalindrome(pl_str)){
                temp.add(pl_str);
                //hypothesis
                solve(s,temp,i+1);
                //backtrack
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;

        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}