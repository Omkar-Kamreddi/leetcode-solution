// Last updated: 8/14/2026, 9:58:13 AM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        boolean used[] = new boolean[n];

        int unplacedCount = 0;

        for(int fruit : fruits){

            boolean placed = false;

            for(int j = 0; j<n; j++){
                if(!used[j] && baskets[j] >= fruit){
                    used[j] = true;
                    placed= true;
                    break;
                }
            }

            if(!placed){
                unplacedCount++;
            }
        }
        return unplacedCount;
    }
}