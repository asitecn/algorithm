public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            while(!stack.isEmpty() && heights[stack.peek()] > height) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
                int area = w * h;
                //System.out.println(w + "\t" + h);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
