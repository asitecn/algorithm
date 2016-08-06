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

/*
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  
*/

    class Pair {
        TreeNode root;
        TreeNode rightBottom;
        public Pair(TreeNode root, TreeNode rightBottom) {
            this.root = root;
            this.rightBottom = rightBottom;
        }
    }

    public Pair upsideDown(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Pair(root, root);
        }
        Pair left = upsideDown(root.left);
        left.rightBottom.left = root.right;
        left.rightBottom.right = root;
        root.right = null;
        root.left = null;
        return new Pair(left.root, left.rightBottom.right);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return upsideDown(root).root;
    }
}
