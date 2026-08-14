// Last updated: 8/14/2026, 10:11:19 AM
class Solution {
    

    public List<String> generateParenthesis(int n) {

        StringBuilder str = new StringBuilder();
        int open = n;
        int close = n;
        ArrayList<String> result = new ArrayList<>();

        solve(open,close,str,result);

        return result;
    }

    public void solve(int open,int close,StringBuilder str,ArrayList<String> result){

        //base case
        if(open == 0 && close == 0){
            result.add(str.toString());
            return ;
        }

        if(open != 0){
            str.append("(");
            solve(open-1,close,str,result);
            str.deleteCharAt(str.length()-1);
        }

        if(close > open ){
            str.append(")");
            solve(open,close-1,str,result);
            str.deleteCharAt(str.length()-1);
        }
        return ;
    }
}