/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode ehead = new ListNode(0);
        ListNode ohead = new ListNode(0);
        
        ListNode node = head;
        ListNode even = ehead;
        ListNode odd = ohead;
        int count = 1;
        while(node != null) {
            if (count % 2 == 0) {
                even.next = node;
                even = node;
            } else {
                odd.next = node;
                odd = node;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
            count++;
        }
        if (ohead.next == null) {
            return ehead.next;
        } else {
            odd.next = ehead.next;
            return ohead.next;
        }
    }
}
