import java.util.*;
public class LargestHistogram {

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        height = Arrays.copyOf(height, height.length+1);

        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i = 0; i < height.length; i++) {
            while(stack.peek() > -1 && height[stack.peek()] > height[i]) {
                maxArea = Math.max(maxArea, height[stack.pop()] * (i - stack.peek()-1));
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String args[]) {
        LargestHistogram lh = new LargestHistogram();
        System.out.println(lh.largestRectangleArea(new int[]{1, 1}));
    }

}
