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
    public void pushLeft(Stack<TreeNode> stack, TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null || node.right == prev) {
                node = stack.pop();
                res.add(node.val);
                prev = node;
            } else {
                pushLeft(stack, node.right);
            }
        }
        return res;
    }
}
