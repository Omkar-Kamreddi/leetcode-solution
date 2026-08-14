// Last updated: 8/14/2026, 10:11:02 AM
class Solution {
    public int longestValidParentheses(String s) {

        //case 1: empty
        if(s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}