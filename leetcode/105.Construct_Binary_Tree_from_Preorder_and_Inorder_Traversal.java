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
    
    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = is;
        for(; idx <= ie; idx++) {
            if (preorder[ps] == inorder[idx]) {
                break;
            }
        }
        root.left = buildTree(preorder, ps + 1, ps + (idx - is), inorder, is, idx - 1);
        root.right = buildTree(preorder, ps + (idx - is) + 1, pe, inorder, idx + 1, ie);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
