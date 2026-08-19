// Last updated: 8/19/2026, 8:13:23 PM
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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        
14        //Base case
15        ListNode check = head;
16        for(int i =0; i<k; i++){
17            if(check == null){
18                return head;
19            }
20
21            check = check.next;
22        }
23
24        ListNode prev = null;
25        ListNode curr = head;
26
27        for(int step=0; step<k; step++){
28            ListNode next = curr.next;
29            curr.next = prev;
30            prev = curr;
31            curr = next;
32        }
33
34        head.next = reverseKGroup(curr,k);
35
36        return prev;
37    }
38}