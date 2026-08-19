// Last updated: 8/19/2026, 9:20:22 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode mergeKLists(ListNode[] lists) {
13
14        
15        
16        //step 1) store the current smallest available node from each list
17        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val)); 
18
19        for(ListNode startNode : lists){
20            if(startNode != null){
21                minHeap.offer(startNode);
22            }
23        }
24
25        //step 2) poll -> Smallest current node among all lists &  Its next node is now a candidate
26
27        ListNode dummy = new ListNode(0);
28        ListNode tail = dummy;
29
30        while(!minHeap.isEmpty()){
31
32            ListNode smallestNode = minHeap.poll();
33
34            tail.next = smallestNode;
35            tail = smallestNode;
36
37            //he will be candidate
38            if(smallestNode.next != null){
39                minHeap.offer(smallestNode.next);
40            }
41
42        }
43        return dummy.next;
44    }
45}