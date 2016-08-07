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
    
    public void traverse(TreeNode root, String path, List<String> results) {
        if (root == null) {
            return;
        }
        path += (path.length() == 0 ? "" : "->") + root.val;
        if (root.left == null && root.right == null) {
            results.add(path);
        } else {
            if (root.left != null) {
                traverse(root.left, path, results);
            }
            if (root.right != null) {
                traverse(root.right, path, results);
            }
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new LinkedList<String>();
        if (root == null) {
            return output;
        }
        String path = "";
        traverse(root, path, output);
        return output;
    }
}
