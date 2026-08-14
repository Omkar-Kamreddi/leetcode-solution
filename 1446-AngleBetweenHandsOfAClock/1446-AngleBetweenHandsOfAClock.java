// Last updated: 8/14/2026, 10:04:33 AM
class Solution {
    public double angleClock(int hour, int minutes) {

        double hrAngle = (hour%12)*30 + 0.5 * minutes;

        double minAngle = minutes * 6;

        double diff = Math.abs(hrAngle - minAngle);

        return Math.min(diff,360-diff);
        
    }
}