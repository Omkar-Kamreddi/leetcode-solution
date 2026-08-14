// Last updated: 8/14/2026, 10:11:30 AM
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
    int count = 0;
    int len = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //case
        if(head.next == null){
            head = null;
            return head;
        }

        int length = calculate( head);

        //case
        if(length == n){
            return head.next;
        }

        int delete = length - n;
        ListNode mover = head;
        ListNode prev = head;
        while(mover != null){

            if(count == (delete)){
                prev.next = mover.next;
                break;
            }
            count++;
            prev = mover;
            mover = mover.next;
        } 
        return head;
    }

    public int calculate(ListNode node){
        while(node!=null){
            len++;
            node = node.next;
        }
        return len;
    }
}