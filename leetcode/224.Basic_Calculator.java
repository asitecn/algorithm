// Solution 1
public class Solution {
    public int calculate(String s) {
        /*
            "1 + 1" = 2
            " 2-1 + 2 " = 3
            "(1+(4+5+2)-3)+(6+8)" = 23
        */
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        int num = 0;
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign*num;
                sign = (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign*num;
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign*result;
                num = 0;
            }
        }
        return result += sign*num;
    }
}

// Soluion 2
public class Solution {
    public int op(int val2, int val1, char op) {
        if (op == '+') {
            return val1 + val2;
        }
        return val1 - val2;
    }
    
    public int calculate(String s) {
        s = s + "+";
        // "(1+(4+5+2)-3)+(6+8)" = 23
        Stack<Integer> stack = new Stack<>();
        Stack<Character> symbols = new Stack<>();
        
        int num = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                symbols.push(c);
            } else if (c == ')') {
                while(symbols.peek() != '(') {
                    stack.push(op(stack.pop(), stack.pop(), symbols.pop()));
                }
                symbols.pop();
            } else if (c == '+' || c == '-') {
                if (!symbols.isEmpty() && (symbols.peek() == '+' || symbols.peek() == '-')) {
                    stack.push(op(stack.pop(), stack.pop(), symbols.pop()));
                }
                symbols.push(c);
            } else {
                num = num*10 + (c - '0');
                if (i == s.length() - 1 || s.charAt(i+1) < '0' || s.charAt(i+1) > '9') {
                    stack.push(num);
                    num = 0;
                }
            }
        }
        return stack.pop();
    }
}
