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
    
    public void pathSum(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum, int total) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val + total == sum) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        pathSum(res, path, root.left, sum, total + root.val);
        pathSum(res, path, root.right, sum, total + root.val);
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(res, path, root, sum, 0);
        return res;
    }
}
