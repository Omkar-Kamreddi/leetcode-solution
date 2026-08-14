// Last updated: 8/14/2026, 9:59:53 AM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            else if (c == 'R') r++;
        }

        int blanks = moves.length() - l - r;

        return Math.abs(r - l) + blanks;
    }
}