// Last updated: 8/18/2026, 5:11:10 PM
1import java.util.Hashtable;
2import java.util.Map;
3
4class Solution {
5    public boolean wordPattern(String pattern, String s) {
6
7        String []words = s.split(" ");
8
9        //Base case
10        if(pattern.length() != words.length){
11            return false;
12        }
13
14        Map<Character,String> charToWord = new Hashtable<>();
15        Map<String,Character> wordToChar = new Hashtable<>();
16
17        for(int i=0; i<pattern.length(); i++){
18            
19            char ch = pattern.charAt(i);
20            String word = words[i];
21
22            if(charToWord.containsKey(ch)){
23                if(!charToWord.get(ch).equals(word)){
24                    return false;
25                }
26            }
27
28            if(wordToChar.containsKey(word)){
29                if(!wordToChar.get(word).equals(ch)){
30                    return false;
31                }
32            }
33
34            charToWord.put(ch,word);
35            wordToChar.put(word,ch);
36        }
37        
38        return true;
39    }
40}