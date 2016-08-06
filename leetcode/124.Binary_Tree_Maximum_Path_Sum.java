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
    class Result {
        int singleSum;
        int maxSum;
        public Result(int singleSum, int maxSum) {
            this.singleSum = singleSum;
            this.maxSum = maxSum;
        }
    }
    public Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        int singleSum = Math.max(left.singleSum, right.singleSum) + root.val;
        singleSum = Math.max(0, singleSum);
        
        int maxSum = Math.max(left.maxSum, right.maxSum);
        maxSum = Math.max(maxSum, left.singleSum + right.singleSum + root.val);
        
        return new Result(singleSum, maxSum);
    }
    
    public int maxPathSum(TreeNode root) {
        Result res = helper(root);
        return res.maxSum;
    }
}
