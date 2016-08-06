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
    public List<Integer> getIntegerList(List<TreeNode> treeList) {
        List<Integer> list = new LinkedList<Integer>();
        for(TreeNode n : treeList) {
            list.add(n.val);
        }
        return list;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) {
            return results;
        }
        
        List<TreeNode> q1 = new LinkedList<TreeNode>();
        List<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root);
        results.add(getIntegerList(q1));

        while(!q1.isEmpty()) {
            TreeNode node = q1.remove(0);
            if (node.left != null) {
                q2.add(node.left);
            }
            if (node.right != null) {
                q2.add(node.right);
            }
            if (q1.isEmpty()) {
                if (!q2.isEmpty()) {
                    results.add(getIntegerList(q2));
                    List<TreeNode> temp = q1;
                    q1 = q2;
                    q2 = temp;
                }
            }
        }
        
        return results;
    }
}
