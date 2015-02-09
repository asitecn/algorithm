import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
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

public class FindSum {

    public void findSum(TreeNode root, List<Integer> buffer, int target) {
        if (root == null) {
            return;
        }
        buffer.add(root.val);
        int temp = target;
        for(int i = buffer.size()-1; i >= 0; i--) {
            temp -= buffer.get(i);
            if (temp == 0) {
                for(int j = i; j < buffer.size(); j++) {
                    System.out.print(buffer.get(j));
                }
                System.out.println();
            }
        }
        List<Integer> buffer1 = new ArrayList<>(buffer);
        List<Integer> buffer2 = new ArrayList<>(buffer);
        findSum(root.left, buffer1, target);
        findSum(root.right, buffer2, target);
    }

    public void findSum(TreeNode root, int target) {
        List<Integer> buffer = new ArrayList<>();
//        findSum(root, buffer, target);
        sumFromRoot(root, buffer, 0, target);
    }

    public void sumFromRoot(TreeNode root, List<Integer> buffer, int sum, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        buffer.add(root.val);
        if (sum == target) {
            for(int i = 0; i < buffer.size(); i++) {
                System.out.print(buffer.get(i));
            }
            System.out.println();
        }
        List<Integer> buffer1 = new ArrayList<>(buffer);
        List<Integer> buffer2 = new ArrayList<>(buffer);
        sumFromRoot(root.left, buffer1, sum, target);
        sumFromRoot(root.right, buffer2, sum, target);
    }

    public static void main(String args[]) {
        FindSum f = new FindSum();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);
        TreeNode t3 = new TreeNode(3, null, t1);
        TreeNode t4 = new TreeNode(4, t2, null);
        TreeNode t5 = new TreeNode(5, null, t2);
        TreeNode t6 = new TreeNode(6, t3, null);
        TreeNode t7 = new TreeNode(7, null, t3);
        
        f.findSum(t1, 7);
    }
}
