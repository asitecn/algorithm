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
    
    public TreeNode buildTree(int[] inorder, int i1, int i2, int[] postorder, int p1, int p2) {
        if (i1 > i2 || p1 > p2) {
            return null;
        }
        int i = i1;
        for(; i <= i2; i++) {
            if (inorder[i] == postorder[p2]) {
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[p2]);
        root.left = buildTree(inorder, i1, i - 1, postorder, p1, p1 - 1 + (i - i1));
        root.right = buildTree(inorder, i + 1, i2, postorder, p1 + (i - i1), p2 - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}
