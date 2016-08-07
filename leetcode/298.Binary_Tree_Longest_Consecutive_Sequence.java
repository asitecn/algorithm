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
    int maxCount;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxCount = 0;
        longestConsecutive(root, 1);
        return maxCount;
    }    

    public void longestConsecutive(TreeNode root, int count) {
        maxCount = Math.max(count, maxCount);
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        
        if (root.left != null && root.val == root.left.val - 1) {
            longestConsecutive(root.left, count+1);
        } else {
            longestConsecutive(root.left, 1);
        }
        if (root.right != null && root.val == root.right.val - 1) {
            longestConsecutive(root.right, count+1);
        } else {
            longestConsecutive(root.right, 1);
        }
    }
}
