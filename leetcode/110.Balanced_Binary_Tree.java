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
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int ld = depth(root.left);
        int rd = depth(root.right);
        if (Math.abs(ld - rd) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }
    */
    
    public class Pair {
        int height;
        boolean balanced;
        public Pair(int h, boolean b) {
            this.height = h;
            this.balanced = b;
        }
    }
    
    public Pair isBalancedDepth(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }
        Pair lp = isBalancedDepth(root.left);
        Pair rp = isBalancedDepth(root.right);
        int height = Math.max(lp.height, rp.height) + 1;
        boolean isBalanced = lp.balanced && rp.balanced && (Math.abs(lp.height - rp.height) <= 1);
        return new Pair(height, isBalanced);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedDepth(root).balanced;
    }
    
}
