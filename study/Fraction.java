import java.util.*;
public class Fraction {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder s = new StringBuilder();
        if (denominator == 0) {
            return "";
        }
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            s.append("-");
        }
        
        long num = Math.abs(numerator);
        long denom = Math.abs((long)denominator);
        long q = num / denom;
        long r = num % denom;
        s.append(q);
        if (r != 0) {
            s.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while(r != 0) {
                if (map.get(r) == null) {
                    map.put(r, s.length());
                    r*=10;
                    System.out.println(r +"\t" + denom + "\t" + (r/denom));
                    s.append(r / denom);
                    r %= denom;
                } else {
                    s.insert(map.get(r), "(");
                    s.append(")");
                    break;
                }
            }
        }
        return s.toString();
    }

    public static void main(String args[]) {
        Fraction f = new Fraction();
        System.out.println(f.fractionToDecimal(-1, -2147483648));
    }
}
