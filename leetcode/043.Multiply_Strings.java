public class Solution {
    public String add(String s1, String s2) {
        if ("0".equals(s1)) {
            return s2;
        }
        StringBuilder sb = new StringBuilder();
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        int carryon = 0;
        while(i1 >= 0 || i2 >= 0) {
            int val = (i1 >= 0 ? s1.charAt(i1) - '0' : 0) + (i2 >= 0 ? s2.charAt(i2) - '0' : 0) + carryon;
            sb.insert(0, val % 10);
            carryon = val / 10;
            i1--;
            i2--;
        }
        if (carryon > 0) {
            sb.insert(0, carryon);
        }
        return sb.toString();
    }

    public String multiply(int c, String num, int base) {
        if (c == 0) {
            return "0";
        }
        int carryon = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--) {
            int val = c * (num.charAt(i) - '0') + carryon;
            sb.insert(0, val % 10);
            carryon = val / 10;
        }
        if (carryon > 0) {
            sb.insert(0, carryon);
        }
        for(int i = 0; i < base; i++) {
            sb.append("0");
        }
        return sb.toString();
    }    
    
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // 345 * 678
        int base = 0;
        String res = "0";
        for(int i = num1.length() - 1; i >= 0 ; i--) {
            res = add(res, multiply(num1.charAt(i) - '0', num2, base++));
        }
        return res;
    }
}
