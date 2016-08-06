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
    
    public void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        TreeNode prev = null;
        TreeNode cur = null;
        TreeNode candidate1 = null;
        TreeNode candidate2 = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushLeft(stack, node.right);

            if (prev == null) {
                prev = node;
                continue;
            }
            cur = node;
            if (prev.val >= cur.val) {
                if (candidate1 == null) {
                    candidate1 = prev;
                    candidate2 = cur;
                } else {
                    swap(candidate1, cur);
                    return;
                }
            }
            prev = cur;
        }
        
        if (candidate1 != null) {
            swap(candidate1, candidate2);
        }
    }
}
