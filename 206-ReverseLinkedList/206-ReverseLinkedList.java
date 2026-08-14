// Last updated: 8/14/2026, 10:07:50 AM
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
    public ListNode reverseList(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;

        while(current != null){
            
            current.next = previous;
            
            previous = current;
            current = next;

            if(next != null){
                next = current.next;
            }
        }
        
        head = previous; 

        return head;

    }
}