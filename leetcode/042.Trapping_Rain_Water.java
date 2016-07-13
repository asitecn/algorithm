public class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            left[i] = (i == 0 ? height[i] : Math.max(left[i-1], height[i]));
        }
        for(int i = height.length - 1; i >= 0; i--) {
            right[i] = (i == height.length - 1 ? height[i] : Math.max(right[i+1], height[i]));
        }

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
