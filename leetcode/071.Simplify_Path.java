public class Solution {
    
    // path = "/home/", => "/home"
    // path = "/a/./b/../../c/", => "/c"

    public String simplifyPath(String path) {
        String[] symbols = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < symbols.length; i++) {
            if (".".equals(symbols[i]) || "".equals(symbols[i])) {
                continue;
            } else if ("..".equals(symbols[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(symbols[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
