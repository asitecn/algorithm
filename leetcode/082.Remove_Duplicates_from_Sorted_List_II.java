/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1 2 3 3 4 4 5
        // 1 2 5
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode node = head;
        ListNode next = node.next;

        while(node != null && next != null) {
            if (node.val == next.val) {
                while(next != null && next.val == node.val) {
                    next = next.next;
                }
                prev.next = next;
                node = next;
                if (next != null) {
                    next = node.next;
                }
            } else {
                prev = node;
                node = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }
        
        return dummy.next;
    }
}
