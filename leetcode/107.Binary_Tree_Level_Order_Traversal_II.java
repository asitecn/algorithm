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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null) {
            return output;
        }
        
        List<TreeNode> l1 = new LinkedList<TreeNode>();
        List<TreeNode> l2 = new LinkedList<TreeNode>();
        l1.add(root);
        {
            List<Integer> result = new LinkedList<Integer>();
            result.add(root.val);
            output.add(result);
        }
        while(!l1.isEmpty()) {
            TreeNode node = l1.remove(0);
            if (node.left != null) {
                l2.add(node.left);
            }
            if (node.right != null) {
                l2.add(node.right);
            }
            if (l1.isEmpty()) {
                if (!l2.isEmpty()) {
                    List<Integer> result = new LinkedList<Integer>();
                    for(TreeNode n : l2) {
                        result.add(n.val);
                    }
                    output.add(0, result);
                    List<TreeNode> temp = l1;
                    l1 = l2;
                    l2 = temp;
                }
            }
        }
        return output;
    }
}
