/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null ? l2 : l1);
        }
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode(1);
        ListNode prev = dummy;
        int addon = 0;
        while(n1 != null || n2 != null) {
            int value = (n1 == null ? 0 : n1.val) + (n2 == null ? 0 : n2.val) + addon;
            addon = value / 10;
            prev.next = new ListNode(value % 10);
            prev = prev.next;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (addon == 1) {
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }
}
