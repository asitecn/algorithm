class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode leftParent, TreeNode rightParent) {
        this.val = val;
        if (leftParent != null) {
                leftParent.left = this;
        }
        if (rightParent != null) {
                rightParent.right = this;
        }
    }
}

public class CommonAncestor {

/*
    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.left, p) || covers(root.right, p);
    }

    public TreeNode common(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        boolean pOnLeft = covers(root.left, p);
        boolean qOnLeft = covers(root.left, q);
        if (pOnLeft && qOnLeft) {
            return common(root.left, p, q);
        } else if (!pOnLeft && !qOnLeft) {
            return common(root.right, p, q);
        } else {
            return root;
        }
    }
*/

    public TreeNode covers(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (covers(root.left, p) != null || covers(root.right, p) != null) {
            return root;
        }
        return null;
    }

    public TreeNode common(TreeNode root, TreeNode p, TreeNode q) { 
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode pLeft = covers(root.left, p);
        TreeNode pRight = covers(root.right, p);
        TreeNode qLeft = covers(root.left, q);
        TreeNode qRight = covers(root.right, q);
        if (pLeft != null && qLeft != null) {
            return common(root.left, p, q);
        } else if (pRight != null && qRight != null) {
            return common(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t3 = new TreeNode(3, null, t1);
        TreeNode t4 = new TreeNode(4, t2, null);
        TreeNode t5 = new TreeNode(5, null, t2);
        TreeNode t6 = new TreeNode(6, t3, null);
        TreeNode t7 = new TreeNode(7, null, t3);
        
        CommonAncestor cm = new CommonAncestor();
        TreeNode t = cm.common(t1, t3, t7);
        System.out.println(t.val);
    }
}
