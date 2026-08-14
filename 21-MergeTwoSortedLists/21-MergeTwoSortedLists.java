// Last updated: 8/14/2026, 10:11:25 AM
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode temp01 = list1;
        ListNode temp02 = list2;
        ListNode res = new ListNode(0);
        ListNode curr = res;

        while(temp01!= null && temp02 != null){
            if(temp01.val <= temp02.val){
                curr.next = temp01;
                curr = temp01;
                temp01 = temp01.next;
            }else{
                curr.next = temp02;
                curr = temp02;
                temp02 = temp02.next;
            }    
        }
        while(temp01 != null){
            curr.next = temp01;
            curr = temp01;
            temp01 = temp01.next;
        }
        while(temp02 != null){
            curr.next = temp02;
            curr = temp02;

            temp02 = temp02.next;
        }
        return res.next;
    }
}