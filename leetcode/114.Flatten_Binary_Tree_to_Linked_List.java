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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        prev = root;
        root.left = null;
    }
    */
    
    public void pushRight(Stack<TreeNode> stack, TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.right;
        }
    }
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushRight(stack, root);
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null || node.left == prev) {
                node = stack.pop();
                node.right = prev;
                node.left = null;
                prev = node;
            } else {
                pushRight(stack, node.left);
            }
        }
    }
}
