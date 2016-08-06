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
    int sum = 0;
    
    // top down
    public void sumNumbers(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        sumNumbers(root.left, val);
        sumNumbers(root.right, val);
    }
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbers(root, 0);
        return sum;
    }
}
