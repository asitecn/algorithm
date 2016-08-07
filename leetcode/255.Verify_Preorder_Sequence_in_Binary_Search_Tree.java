public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int val : preorder) {
            if (val < min) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < val) {
                min = stack.pop();
            }
            stack.push(val);
        }
        
        return true;
    }
}
