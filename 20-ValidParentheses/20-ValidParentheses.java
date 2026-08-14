// Last updated: 8/14/2026, 10:11:29 AM
class Solution {
    public boolean isValid(String s) {

        //using stack data structure

        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length() ; i++){

            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if( !stack.isEmpty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }else if(!stack.isEmpty() && ch == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(!stack.isEmpty() && ch == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
    
            return stack.isEmpty();
        
    }
}