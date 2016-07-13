public class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int max = 0;
        while (s < e) {
            int width = e - s;
            if (height[s] < height[e]) {
                max = Math.max(max, width * height[s]);
                s++;
            } else {
                max = Math.max(max, width * height[e]);
                e--;
            }
        }
        return max;
    }
}
