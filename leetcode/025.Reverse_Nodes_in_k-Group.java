/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {

        // Given this linked list: 1->2->3->4->5
        // For k = 2, you should return: 2->1->4->3->5
        // For k = 3, you should return: 3->2->1->4->5
        
        // recursion
        
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        for(int i = 0; i < k; i++) {
            if (tail.next != null) {
                tail = tail.next;
            } else {
                return head;
            }
        }
        
        ListNode next = tail.next;
        tail.next = null;
        
        ListNode reversed = reverse(head);
        head.next = reverseKGroup(next, k);
        
        return reversed;
    }
}
