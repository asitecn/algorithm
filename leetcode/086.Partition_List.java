/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode(0);
        ListNode mh = new ListNode(0);
        ListNode less = lh;
        ListNode more = mh;
        while(head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        less.next = mh.next;
        more.next = null;
        return lh.next;
    }
}
