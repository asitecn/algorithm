//给一个string of nested ternary operations例如a?b?c:d:e，build a tree：root是
//a，左子树是b?c:d对应的tree ，右子树是e。保证input都是valid的。

import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    String val;
    public TreeNode(String val) {
        this.val = val;
    }
    public TreeNode(char val) {
        this.val = "" + val;
    }
}

public class NestedTernary {
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public TreeNode parse(String str) {
        str += '$';
        Stack<Character> symbols = new Stack<>();
        Stack<Character> ops = new Stack<>();
        TreeNode root = null;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ':' || c == '$') {
                while(!ops.isEmpty() && ops.peek() == ':') {
                    if (root == null) {
                        String s = "" + ops.pop() + symbols.pop();
                        s = "" + ops.pop() + symbols.pop() + s;
                        s = "" + symbols.pop() + s;

                        root = new TreeNode(s);
                        symbols.push('#');
                    } else {
                        char right = symbols.pop();
                        char left = symbols.pop();
                        char exp = symbols.pop();
                        ops.pop();
                        ops.pop();
                        TreeNode newRoot = new TreeNode(exp);
                        newRoot.left = (left == '#' ? root : new TreeNode(left));
                        newRoot.right = (right == '#' ? root : new TreeNode(right));
                        symbols.push('#');
                        root = newRoot;
                    }
                }
                ops.push(':');
            } else {
                if (c == '?') {
                    ops.push(c);
                } else {
                    symbols.push(c);
                }
            }
        }
        return root;
    }

    public static void main(String args[]) {
        NestedTernary nt = new NestedTernary();
//        TreeNode root = nt.parse("a?b?c:d:e");
//        TreeNode root = nt.parse("a?b?c?d:e:f:g");
        TreeNode root = nt.parse("a?b?c:d?e:f:g");
        nt.inorder(root);
    }
}
