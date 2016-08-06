/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    int len(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        // Given 1->2->3->4->5->NULL and k = 2,
        // return 4->5->1->2->3->NULL.        

        int len = len(head);
        if (len <= 1 || k == 0) {
            return head;
        }
        k %= len;
        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < len; i++) {
            if (i >= k) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = dummy.next;
        return newHead;
    }
}
