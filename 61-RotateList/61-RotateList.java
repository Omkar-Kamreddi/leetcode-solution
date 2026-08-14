// Last updated: 8/14/2026, 10:09:51 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        //base case
        if(head == null || head.next == null || k==0 )
            return head;

        ListNode curr = head;
        int len = 1;

        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        //Make circle
        curr.next = head;

        // Normalize k
        k = k % len;

        int newHeadPos = len - k;
        ListNode newTail = head;

        for(int i=1; i< newHeadPos; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        //remove circle
        newTail.next = null;
        return newHead;
    }
}