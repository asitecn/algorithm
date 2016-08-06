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
        
        TreeLinkNode h1 = root;
        TreeLinkNode h2 = new TreeLinkNode(0);
        
        TreeLinkNode h2cur = h2;
        while(h1 != null) {
            if (h1.left != null) {
                h2cur.next = h1.left;
                h2cur = h2cur.next;
            }
            if (h1.right != null) {
                h2cur.next = h1.right;
                h2cur = h2cur.next;
            }
            h1 = h1.next;
            if (h1 == null) {
                h1 = h2.next;
                h2 = new TreeLinkNode(0);
                h2cur = h2;
            }
        }
    }
}
