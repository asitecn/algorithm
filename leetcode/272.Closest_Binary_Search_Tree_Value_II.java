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
    
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val >= p.val) {
            return predecessor(root.left, p);
        }
        TreeNode right = predecessor(root.right, p);
        return (right == null ? root : right);
    }
    
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return successor(root.right, p);
        }
        TreeNode left = successor(root.left, p);
        return (left == null ? root : left);
    }
    
    public TreeNode closestNode(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        TreeNode minNode = null;
        
        TreeNode node = root;
        while (node != null) {
            if (node.val == target) {
                return node;
            }
            double value = Math.abs(node.val - target);
            if (value < min) {
                min = value;
                minNode = node;
            }
            
            if (node.val < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return minNode;
        //return closer(node, prev, target);
    }
    
    public TreeNode closer(TreeNode n1, TreeNode n2, double target) {
        //System.out.println(n1.val + "\t" + n2.val);
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null || n2 == null) {
            return (n1 == null ? n2 : n1);
        }
        return (Math.abs(n1.val - target) - Math.abs(n2.val - target) <= 0 ? n1 : n2);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || k == 0) {
            return res;
        }

        TreeNode closest = closestNode(root, target);
        TreeNode pre = closest;
        TreeNode post = closest;
        TreeNode closer = closest;
        res.add(closer.val);
        for(int i = 1; i < k; i++) {
            if (pre != null && closer == pre) {
                pre = predecessor(root, pre);
            }
            if (post != null && closer == post) {
                post = successor(root, post);
            }
            //System.out.println(closer.val + "\t" + pre + "\t" + post);
            closer = closer(pre, post, target);
            if (closer == null) {
                break;
            }
            if (closer == pre) {
                res.add(0, closer.val);
            } else {
                res.add(closer.val);
            }
        }
        
        return res;
    }
}
