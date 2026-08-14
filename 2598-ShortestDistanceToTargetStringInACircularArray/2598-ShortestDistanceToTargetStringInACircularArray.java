// Last updated: 8/14/2026, 10:01:36 AM
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for(int i=0; i<= n-1; i++){
            if(words[i].equals(target)){
                //forward distance
                int direct = Math.abs(i - startIndex);
                //backward (circular) distance
                int circular = n - direct;
                //min(forward,backward)
                int dist = Math.min(direct, circular);

                minDist = Math.min(minDist,dist);
            }
        }

        if(minDist != Integer.MAX_VALUE){
            return minDist;
        }else{
            return -1;
        }

    }
}