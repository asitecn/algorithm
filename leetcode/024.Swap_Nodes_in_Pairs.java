/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        /*
        //  Given 1->2->3->4, you should return the list as 2->1->4->3. 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = head;
        while(node != null && node.next != null) {
            // prev -> node -> next -> next2
            // prev -> next -> node -> next2
            //                  prev    node
            ListNode next = node.next;
            ListNode next2 = next.next;
            
            prev.next = next;
            next.next = node;
            node.next = next2;
            prev = node;
            node = next2;
        }
        return dummy.next;
        */

        /*
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode node = head.next;
        while (cur != null && cur.next != null) {
            ListNode next = node.next;
            node.next = cur;
            cur.next = next;
            cur = next;
        }
        
        return head.next;
        */


        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null && cur.next != null) {
            //System.out.println(cur.val);
            ListNode next = cur.next;
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp;
            if (prev != null) {
                prev.next = next;
            } else {
                newHead = next;
            }
            prev = cur;
            cur = temp;
        }
        
        return newHead;
    }
}
