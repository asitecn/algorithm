/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int height(TreeNode root, boolean isLeft) {
        int height = 0;
        while(root != null) {
            height++;
            root = (isLeft ? root.left : root.right);
        }
        return height;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, true);
        int rh = height(root.right, false);
        if (lh == rh) {
            return (1 << (lh+1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
