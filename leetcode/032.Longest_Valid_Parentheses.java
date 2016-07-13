public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        if (s.length() == stack.size()) {
            return 0;
        }

        int max = 0;
        // )()())( => 0, 5, 6
        int end = s.length();
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            if (end - idx > 1) {
                max = Math.max(max, end - idx - 1);
            }
            end = idx;
        }
        if (stack.isEmpty()) {
            max = Math.max(max, end);
        }
        return max;
    }
}
