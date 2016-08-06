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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            pushLeft(stack, node.right);
        }
        return res;
    }
}
