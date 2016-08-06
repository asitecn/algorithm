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
    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int m = i + (j-i)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBST(nums, i, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, j);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}
