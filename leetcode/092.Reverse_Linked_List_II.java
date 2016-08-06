/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //if (head == null || head.next == null || m == n) {
        //    return head;
        //}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode node = head;
        for(int i = 1; i < m; i++) {
            prev = prev.next;
            node = node.next;
        }
        
        // disconnect
        prev.next = null;
        ListNode tail = node;
        
        // reverse
        ListNode p = null;
        ListNode q = node;
        for(int i = m; i <= n; i++) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        
        // reconnect
        prev.next = p;
        tail.next = q;
        return dummy.next;
    }
}
