/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode head = root;
        TreeLinkNode nextHead = null;
        TreeLinkNode prev = null;
        while(head != null) {
            /*
            if (head.left == null && head.right == null) {
                break;
            }*/
            if (nextHead == null) {
                if (head.left != null) {
                    nextHead = head.left;
                } else if (head.right != null) {
                    nextHead = head.right;
                }
            }
            if (prev != null) {
                if (head.left != null) {
                    prev.next = head.left;
                    head.left.next = head.right;
                    prev = (head.right != null ? head.right : head.left);
                } else if (head.right != null) {
                    prev.next = head.right;
                    prev = head.right;
                }
            } else {
                if (head.left != null) {
                    head.left.next = head.right;
                    prev = (head.right != null ? head.right : head.left);
                } else if (head.right != null) {
                    prev = head.right;
                }
            }
            head = head.next;
            if (head == null) {
                if (nextHead == null) {
                    break;
                }
                head = nextHead;
                nextHead = null;
                prev = null;
            }
        }
    }
}
