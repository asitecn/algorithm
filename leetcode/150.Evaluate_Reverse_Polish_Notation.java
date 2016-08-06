public class Solution {
    public int op(int num1, int num2, String op) {
        if (op.equals("+")) {
            return num2 + num1;
        }
        if (op.equals("-")) {
            return num2 - num1;
        }
        if (op.equals("*")) {
            return num2 * num1;
        }
        return num2 / num1;
    }
    
    public int evalRPN(String[] tokens) {
        // ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        // ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
        
        Set<String> set = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens) {
            if (set.contains(s)) {
                stack.push(op(stack.pop(), stack.pop(), s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
