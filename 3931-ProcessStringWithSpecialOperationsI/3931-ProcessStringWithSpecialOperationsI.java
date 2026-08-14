// Last updated: 8/14/2026, 9:57:43 AM
class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                res.append(ch);
            } 
            else if (ch == '*') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } 
            else if (ch == '#') {
                String cur = res.toString();
                res.append(cur);
            } 
            else if (ch == '%') {
                res.reverse();
            }
        }

        return res.toString();
    }
}