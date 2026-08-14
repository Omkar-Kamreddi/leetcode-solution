// Last updated: 8/14/2026, 10:07:11 AM
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int n : nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)->a.getValue() - b.getValue());

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            minHeap.offer(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int ans[] = new int[k];
        int idx = 0;

        while(!minHeap.isEmpty()){
            ans[idx++] = minHeap.poll().getKey();
        }
        return ans;
    }
}