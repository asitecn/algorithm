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
    int count = 0;

    public boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean left = isUnival(root.left);
        boolean right = isUnival(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }
}
