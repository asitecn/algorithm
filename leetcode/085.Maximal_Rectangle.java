public class Solution {
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int maxArea = 0;
        for(int i = 0; i < heights.length + 1; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty() ? i : i - 1 - stack.peek());
                int area = h * w;
                maxArea = Math.max(area, maxArea);
                //System.out.println("h=" + h + ",w=" + w + ",area=" + area + ",i=" + i);
            }
            stack.push(i);
            //System.out.println(Arrays.toString(stack.toArray()));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length; 
        int n = matrix[0].length;
        int heights[] = new int[n];
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
}
