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
    class Pair {
        TreeNode node;
        int offset;
        public Pair(TreeNode node, int offset) {
            this.node = node;
            this.offset = offset;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int offset = pair.offset;
            TreeNode node = pair.node;
            if (!map.containsKey(offset)) {
                map.put(offset, new LinkedList<Integer>());
            }
            map.get(offset).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair(node.left, offset - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, offset + 1));
            }
        }
        
        for(Map.Entry<Integer, List<Integer>> me : map.entrySet()) {
            res.add(me.getValue());
        }
        return res;
    }
}
