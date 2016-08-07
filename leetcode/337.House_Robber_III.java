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
    public int rob(TreeNode root, boolean canRobRoot) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return canRobRoot ? root.val : 0;
        }
        int max = rob(root.left, true) + rob(root.right, true);
        if (canRobRoot) {
            max = Math.max(root.val + rob(root.left, false) + rob(root.right, false), max);
        }
        return max;
    }
    
    public int rob(TreeNode root) {
        return rob(root, true);
    }
}
