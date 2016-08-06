/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode node = root;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        
        if (head == null) {
            return;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = head;
        ListNode fast = head;
        // dummy -> 1 -> 2 -> 3 -> 4
        // dummy -> 1 -> 2 -> 3
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h1 = head;
        ListNode h2 = slow.next;
        slow.next = null;
        h2 = reverse(h2);

        ListNode node = dummy;
        while(h1 != null || h2 != null) {
            ListNode h1Next = h1.next;
            node.next = h1;
            node = h1;
            h1 = h1Next;
            
            if (h2 != null) {
                ListNode h2Next = h2.next;
                node.next = h2;
                node = h2;
                h2 = h2Next;
            }
        }
        
        head = dummy.next;
    }
}
