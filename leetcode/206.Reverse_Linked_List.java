/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        while(q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
