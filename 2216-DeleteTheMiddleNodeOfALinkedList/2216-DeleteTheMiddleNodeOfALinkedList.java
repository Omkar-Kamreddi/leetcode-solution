// Last updated: 8/14/2026, 10:02:20 AM
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // If only one node exists, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Count nodes
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int mid = n / 2;

        // Move to node before middle
        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        // Delete middle node
        temp.next = temp.next.next;

        return head;
    }
}