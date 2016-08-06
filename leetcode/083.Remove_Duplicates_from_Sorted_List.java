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
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode node = head.next;
        while(node != null) {
            if (node.val == prev.val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        
        return head;
    }
}
