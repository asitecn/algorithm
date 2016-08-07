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

    public int closestValue(TreeNode root, double target) {
        int value = root.val;
        double min = Double.MAX_VALUE;
        while (root != null) {
            double diff = Math.abs(root.val - target);
            if (min > diff) {
                min = diff;
                value = root.val;
            }
            if (root.val == target) {
                return root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return value;
    }
}
