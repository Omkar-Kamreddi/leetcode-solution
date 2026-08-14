// Last updated: 8/14/2026, 10:09:39 AM
class Solution {
    public String simplifyPath(String path) {

        //eg. path - /a/b/../c/./d//

        //step 1) parse string
        String []str = path.split("/");

        Deque <String>stack = new ArrayDeque<>();

        for(String ch : str){
            if(ch.equals("") || ch.equals(".")){
                continue;
            }
                if(ch.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(ch);
                }
                
            
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder("");

        while(!stack.isEmpty()){
            ans.insert(0,"/"+stack.pop());
        }
        return ans.toString();
    }
}