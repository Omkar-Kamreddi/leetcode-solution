// Last updated: 8/14/2026, 10:11:36 AM
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        String []map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder curr = new StringBuilder();
        backTrack(digits,map,0,curr,list);
        return list;
    }

    public void backTrack(String digits,String []map,int index,StringBuilder curr,ArrayList<String> list){

        //Base condition
        if(index == digits.length()){
            list.add(curr.toString());
            return ;
        }
        //'2'-'0' -> ascii (50-48 = 2(which is integer))  
        String letters = map[digits.charAt(index)-'0'];

        for(char letter : letters.toCharArray()){

            curr.append(letter);
            //expore choice for next number 
            backTrack(digits,map,index+1,curr,list);

            //backtrack
            curr.deleteCharAt(curr.length()-1); //undo
        }

    }

}