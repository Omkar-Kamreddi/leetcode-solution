// Last updated: 8/20/2026, 7:44:37 PM
1class Solution {
2    public int scheduleCourse(int[][] courses) {
3
4        //Step 1) sort by lastDay
5        Arrays.sort(courses,(a,b)->a[1]-b[1]);
6
7        //step 2) using maxHeap to replace large duration course
8        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
9
10        int totalTime = 0;
11
12        for(int i=0; i<courses.length; i++){
13
14            int duration = courses[i][0];
15            int deadLine = courses[i][1];
16
17            //course taken 
18            totalTime += duration;
19            maxHeap.offer(duration);
20
21            if(totalTime > deadLine){
22                int longest = maxHeap.poll();
23                totalTime -= longest;
24            }
25        }
26        return maxHeap.size();
27    }
28}