// Last updated: 8/14/2026, 10:05:48 AM
class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;

        char[] arr = s.toCharArray();

        for (int k = 0; k < s.length(); k++) {

            // left rotate by 1
            char first = arr[0];
            
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = first;

            String temp = new String(arr);
            if (temp.equals(goal)) return true;
        }

        return false;
    }
}