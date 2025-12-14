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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tmp = result;
        int roundVal = 0;

        while (l1 != null && l2 != null) {
            tmp = (tmp.next = new ListNode((l1.val + l2.val + roundVal) % 10));
            roundVal = (l1.val + l2.val + roundVal) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tmp = (tmp.next = new ListNode((l1.val + roundVal) % 10));
            roundVal = (l1.val + roundVal) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp = (tmp.next = new ListNode((l2.val + roundVal) % 10));
            roundVal = (l2.val + roundVal) / 10;
            l2 = l2.next;
        }
        if (roundVal > 0) {
            tmp.next = new ListNode(roundVal);
        }
        return result.next;
    }
}