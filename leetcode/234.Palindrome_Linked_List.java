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
    
    public boolean validate(ListNode vn1, ListNode vn2) {
        while(vn1 != null && vn2 != null) {
            if (vn1.val != vn2.val) {
                return false;
            }
            vn1 = vn1.next;
            vn2 = vn2.next;
        }
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        // Could you do it in O(n) time and O(1) space?
        if (head == null || head.next == null) {
            return true;
        }

        ListNode n1 = head;
        ListNode n2 = head.next;
        while(n2 != null && n2.next != null) {
            n1 = n1.next;
            if (n2.next != null) {
                n2 = n2.next.next;
            } else {
                n2 = null;
            }
        }
        ListNode h2 = n1.next;
        n1.next = null;
        ListNode rh2 = reverseList(h2);
        
        boolean result = validate(head, rh2);
        n1.next = reverseList(rh2);
        return result;
    }
}
