/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
               if (n1.val < n2.val) {
                   return -1;
               } else if (n1.val > n2.val) {
                   return 1;
               } else {
                   return 0;
               }
            } 
        });
        
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        
        if (queue.isEmpty()) {
            return null;
        }

        ListNode head = null;
        ListNode prev = null;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
                prev = node;
                if (node.next != null) {
                    queue.offer(node.next);
                }
                continue;
            }
            prev.next = node;
            prev = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head;
    }
}
