// Solution 1
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

// Solution 2
public class Solution {
    
    // path = "/home/", => "/home"
    // path = "/a/./b/../../c/", => "/c"

    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            int end = i;
            String symbol = path.substring(start, end);
            if (symbol.length() == 0 || symbol.equals(".")) {
                continue;
            } else if (symbol.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(symbol);
            }
        }
        
        String s = "";
        while(!stack.isEmpty()) {
            s = "/" + stack.pop() + s;
        }
        return (s.length() == 0 ? "/" : s);
    }
}
