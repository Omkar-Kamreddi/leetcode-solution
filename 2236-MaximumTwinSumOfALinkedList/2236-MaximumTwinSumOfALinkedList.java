// Last updated: 8/14/2026, 10:02:17 AM
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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();

        // Store all node values
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int maxSum = 0;

        // Check all twin pairs
        for (int i = 0; i < n / 2; i++) {
            maxSum = Math.max(maxSum, list.get(i) + list.get(n - 1 - i));
        }

        return maxSum;
    }
}