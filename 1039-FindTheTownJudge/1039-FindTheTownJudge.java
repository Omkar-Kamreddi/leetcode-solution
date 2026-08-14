// Last updated: 8/14/2026, 10:05:28 AM
class Solution {
    public int findJudge(int n, int[][] trust) {

        int outDegree[] = new int[n+1];
        int inDegree[] = new int[n+1];

        for(int t[] : trust){
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(outDegree[i] == 0 && inDegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}