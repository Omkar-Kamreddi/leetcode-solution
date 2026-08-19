// Last updated: 8/19/2026, 6:57:23 PM
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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        
14        ListNode dummy = new ListNode(0);
15
16        dummy.next = head;
17
18        ListNode prev = dummy;
19
20        for(int i =1; i< left; i++){
21            prev = prev.next;
22        }
23
24        ListNode curr = prev.next;
25
26        for(int i=0; i<right - left; i++){
27            ListNode move = curr.next;
28
29            curr.next = move.next;
30            move.next = prev.next;
31            prev.next = move;
32        }   
33        return dummy.next;
34    }
35}