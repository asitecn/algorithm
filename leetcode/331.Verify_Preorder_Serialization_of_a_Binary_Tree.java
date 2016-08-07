public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        if (strs == null || strs.length == 0) {
            return true;
        }
        
        Stack<String> stack = new Stack<String>();
        stack.push(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            if (i == 1 || !"#".equals(strs[i])) {
                stack.push(strs[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!"#".equals(stack.peek())) {
                    stack.push(strs[i]);
                } else {
                    while (!stack.isEmpty() && "#".equals(stack.peek())) {
                        stack.pop();
                        if (stack.isEmpty() || "#".equals(stack.peek())) {
                            return false;
                        }
                        stack.pop();
                    }
                    stack.push("#");
                } 
            }
        }
        return (stack.size() == 1 ? "#".equals(stack.peek()) : false);
    }
}
