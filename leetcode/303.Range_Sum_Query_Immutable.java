public class NumArray {

// Given nums = [-2, 0, 3, -5, 2, -1]
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3

    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i-1]);
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i == 0 ? 0 : sums[i-1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
