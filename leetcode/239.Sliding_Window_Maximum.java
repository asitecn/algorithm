public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> de = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!de.isEmpty() && nums[i] > nums[de.peekLast()]) {
                de.pollLast();
            }
            de.offerLast(i);
            if (i - de.peekFirst() >= k) {
                de.pollFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[de.peekFirst()];
            }
        }
        return res;
    }
}
