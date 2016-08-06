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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) {
            return results;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();
        boolean pushLeft = true;
        s1.add(root);
        while(!s1.isEmpty()) {
            TreeNode node = s1.pop();
            result.add(node.val);
            if (pushLeft) {
                if (node.left != null) {
                    s2.push(node.left);
                }
                if (node.right != null) {
                    s2.push(node.right);
                }
            } else {
                if (node.right != null) {
                    s2.push(node.right);
                }
                if (node.left != null) {
                    s2.push(node.left);
                }
            }
            if (s1.isEmpty()) {
                Stack<TreeNode> temp = s1;
                s1 = s2;
                s2 = temp;
                pushLeft = !pushLeft;
                
                results.add(result);
                result = new LinkedList<Integer>();
            }
        }
        return results;
    }
}
