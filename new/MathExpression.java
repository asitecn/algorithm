import java.util.*;
class Pair {
    boolean special = false;
    int f;
    int s;
    public Pair(boolean special) {
        this.special = special;
    }
    public boolean equals(Pair p) {
        if (p.special) {
            return special;
        }
        return (f == p.f && s == p.s);
    }

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }

    public void add(Pair p) {
        this.f += p.f;
        this.s += p.s;
    }
    public void minus(Pair p) {
        this.f -= p.f;
        this.s -= p.s;
    }
    public void multiply(Pair p) {
        this.f *= p.s;
        this.s *= p.s;
    }
    @Override
    public String toString() {
        return "(" + f + "," + s + "," + special + ")";
    }
}

public class MathExpression {

    public Pair operation(Pair left, Pair right, char op) {
        if (op == '+') {
            left.add(right);
        } else if (op == '-') {
            left.minus(right);
        } else if (op == '*') {
            left.multiply(right);
        }
        return left;
    }

    public Pair migrate(String s) {
        // 2, 2x, x
        if (s.contains("x")) {
            String rs = s.replaceAll("x", "");
            return new Pair(rs.length() == 0 ? 1 : Integer.parseInt(rs), 0);
        } else {
            return new Pair(0, Integer.parseInt(s));
        }
    }

    public String simplify(String input) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);

        Stack<Pair> tokens = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while(i < input.length()) {
            char c = input.charAt(i);
            if (c == '(') {
                tokens.push(new Pair(true));
            } else if (c == ')') {
                // (3+5*6)*8
                while (!tokens.isEmpty() && !tokens.peek().equals(new Pair(true))) {
                    System.out.println(tokens.peek());
                    Pair right = tokens.pop();
                    Pair left = tokens.pop();
                    char op = ops.pop();
                    System.out.println(left + "\t" + right + "\t" + op + "\t" + tokens.peek());
                    if (tokens.peek().equals(new Pair(true))) {
                        tokens.pop();
                        tokens.push(operation(left, right, op));
                        break;
                    }
                    tokens.push(operation(left, right, op));
                }
            } else if (map.get(c) != null ) {
                // this is a new op,    3+(3*5x)+10
                while (!ops.isEmpty() && map.get(c) <= map.get(ops.peek())) {
                    Pair right = tokens.pop();
                    Pair left = tokens.pop();
                    char op = ops.pop();
                    tokens.push(operation(left, right, op));
                }
                ops.push(c);
            } else {
                // regular symbol
                String symbol = "";
                while(i < input.length() && c != '(' && c != ')' && map.get(c) == null) {
                    symbol += c;
                    c = input.charAt(++i);
                } 
                i--;
                System.out.println(symbol);
                tokens.push(migrate(symbol));
            }
            if (i == input.length()-1) {
                while(!ops.isEmpty()) {
                    Pair right = tokens.pop();
                    Pair left = tokens.pop();
                    char op = ops.pop();
                    tokens.push(operation(left, right, op));
                }
            }
            i++;
        }

        Pair result = tokens.pop();
        return ("" + result.f + "+" + result.s + "x");
    }
   
    public static void main(String args[]) {
        MathExpression me = new MathExpression();
        String result = me.simplify("(x+1)*3+2*(2x+5)");
        System.out.println(result);
    } 

}
