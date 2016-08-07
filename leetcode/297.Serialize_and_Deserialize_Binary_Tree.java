/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root);
        sb.append(root.val + ",");
        while(!q1.isEmpty()) {
            TreeNode node = q1.poll();
            sb.append(node.left == null ? "X," : node.left.val + ",");
            sb.append(node.right == null ? "X," : node.right.val + ",");
            if (node.left != null) {
                q2.offer(node.left);
            }
            if (node.right != null) {
                q2.offer(node.right);
            }
            if (q1.isEmpty()) {
                Queue<TreeNode> temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = (strs[i].equals("X") ? null : new TreeNode(Integer.parseInt(strs[i])));
            i++;
            TreeNode right = (strs[i].equals("X") ? null : new TreeNode(Integer.parseInt(strs[i])));
            i++;
            node.left = left;
            node.right = right;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
