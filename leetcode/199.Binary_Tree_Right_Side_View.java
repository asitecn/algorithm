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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        
        Queue<TreeNode> cq = new LinkedList<TreeNode>();
        Queue<TreeNode> nq = new LinkedList<TreeNode>();
        cq.add(root);
        while(!cq.isEmpty()) {
            TreeNode node = cq.poll();
            if (node.left != null) {
                nq.offer(node.left);
            }
            if (node.right != null) {
                nq.offer(node.right);
            }
            if (cq.isEmpty()) {
                results.add(node.val);
                Queue<TreeNode> temp = cq;
                cq = nq;
                nq = temp;
            }
        }
        return results;
    }
}
