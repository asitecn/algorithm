/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode node = head;
        while(node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            RandomListNode next = node.next;
            node.next = newNode;
            newNode.next = next;
            node = next;
        }
        
        node = head;
        while(node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        RandomListNode newHead = head.next;
        while(node != null) {
            if (node.next.next == null) {
                node.next = null;
                node = null;
            } else {
                RandomListNode next = node.next;
                RandomListNode nextNext = next.next;
                RandomListNode nextNextNext = nextNext.next;
                next.next = nextNextNext;
                node.next = nextNext;
                node = nextNext;
            }
        }
        
        return newHead;
    }
}
