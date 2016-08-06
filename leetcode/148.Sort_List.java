/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                node.next = h1;
                h1 = h1.next;
            } else {
                node.next = h2;
                h2 = h2.next;
            }
            node = node.next;
        }
        while(h1 != null) {
            node.next = h1;
            h1 = h1.next;
            node = node.next;
        }
        while(h2 != null) {
            node.next = h2;
            h2 = h2.next;
            node = node.next;
        }
        return head.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(h2);
        return mergeList(p1, p2);   
    }
}
