// Last updated: 8/14/2026, 10:07:16 AM
class Solution {
    public String removeDuplicateLetters(String s) {
        
        //Step 1) freq count
        int []freq = new int[26];
        boolean visited[] = new boolean[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        //step 2) stack processing 
        for(char ch: s.toCharArray()){

            freq[ch - 'a']--;

            // Already in answer
           if(visited[ch - 'a'])
                continue;

            //maintain lexicographical small
            while(!stack.isEmpty() && ch < stack.peekLast() && freq[stack.peekLast() - 'a'] > 0){
                visited[stack.removeLast()- 'a'] = false;
            }

            stack.addLast(ch);

            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder("");

        while(!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }

        return sb.toString();
    }
}