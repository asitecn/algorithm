public class NumArray {
    
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int low;
        int high;
        int val;
        public SegmentTreeNode(int val, int low, int high) {
            this.val = val;
            this.low = low;
            this.high = high;
        }
    }

    public SegmentTreeNode buildSegmentTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        if (s == e) {
            return new SegmentTreeNode(nums[s], s, s);
        }
        int m = s + (e - s) / 2;
        SegmentTreeNode left = buildSegmentTree(nums, s, m);
        SegmentTreeNode right = buildSegmentTree(nums, m+1, e);
        SegmentTreeNode root = new SegmentTreeNode(left.val + right.val, s, e);
        root.left = left;
        root.right = right;
        return root;
    }
    
    SegmentTreeNode root;
    int[] nums;

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }

    void update(int i, int val) {
        SegmentTreeNode node = root;
        int diff = val - nums[i];
        nums[i] = val;
        while(node != null) {
            node.val += diff;
            int m = node.low + (node.high - node.low) / 2;
            if (i <= m) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public int sumRange(SegmentTreeNode root, int i, int j) {
        if (root == null) {
            return 0;
        }
        if (root.low == i && root.high == j) {
            return root.val;
        }
        int m = root.low + (root.high - root.low) / 2;
        if (i <= m && j <= m) {
            return sumRange(root.left, i, j);
        }
        if (i > m && j > m) {
            return sumRange(root.right, i, j);
        }
        return sumRange(root.left, i, m) + sumRange(root.right, m + 1, j);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
