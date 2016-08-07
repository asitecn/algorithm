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
    class Signal {
        int size;
        int maxSize;
        
        boolean isValid;
        int minValue;
        int maxValue;
        public Signal(int size, int maxSize, boolean isValid, int minValue, int maxValue) {
            this.size = size;
            this.maxSize = maxSize;
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public Signal largest(TreeNode root) {
        if (root == null) {
            //return new Signal(0, 0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
            return null;
        }
        if (root.left == null && root.right == null) {
            return new Signal(1, 1, true, root.val, root.val);
        }
        Signal left = largest(root.left);
        Signal right = largest(root.right);
        
        boolean isLeftValid = (left == null || left.isValid);
        boolean isRightValid = (right == null || right.isValid);
        boolean isValid = isLeftValid && isRightValid 
                && (left == null || root.val >= left.maxValue) && (right == null || root.val <= right.minValue);
        
        int size = (left == null ? 0 : left.size) + (right == null ? 0 : right.size) + 1;
        int minValue = (left == null ? root.val : left.minValue);
        int maxValue = (right == null ? root.val : right.maxValue);
        
        int maxSize = (isValid ? size : Math.max(left == null ? 0 : left.maxSize, right == null ? 0 : right.maxSize));
        return new Signal(size, maxSize, isValid, minValue, maxValue);
    }
        
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return largest(root).maxSize;
    }
}
