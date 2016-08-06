/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); //new starter of the sorted list
        // notice dummy list's end is NULL, not head;
        
        ListNode cur = head; //the node will be inserted
        ListNode pre = dummy; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted

        while (cur != null) {
            next = cur.next;
            // find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
}
