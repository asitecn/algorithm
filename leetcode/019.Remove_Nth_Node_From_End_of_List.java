/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Given linked list: 1->2->3->4->5, and n = 2.
        // After removing the second node from the end, the linked list becomes 1->2->3->5.
   
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        while(fast != null) {
            fast = fast.next;
            if (count++ > n) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
