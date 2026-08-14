// Last updated: 8/14/2026, 10:03:33 AM
class Solution {
    public int largestAltitude(int[] gain) {

        int altitude = 0;
        int maxAltitude = 0;

        for(int g : gain){
            altitude += g;
            maxAltitude = Math.max(maxAltitude,altitude);
        }

        return maxAltitude;
    }
}