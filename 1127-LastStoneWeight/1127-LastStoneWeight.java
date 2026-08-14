// Last updated: 8/14/2026, 10:05:19 AM
class Solution {

    //Max heap using priority queue
    //poll() method get the last elem
 
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);

        for(int i=0; i<stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if(stone1 > stone2){
                pq.add(stone1 - stone2);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }

        return pq.poll();


    }
}