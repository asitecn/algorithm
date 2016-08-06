public class Solution {
    
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator*1.0/denominator < 0) {
            sb.append("-");
        }

        long lNumerator = Math.abs((long)numerator);
        long lDenominator = Math.abs((long)denominator);

        long quotient = lNumerator / lDenominator;
        long remainder = lNumerator % lDenominator;
        sb.append(quotient);
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int pos = sb.length();
        while(remainder != 0) {
            if (map.containsKey(remainder)) {
                pos = map.get(remainder);
                break;
            }
            map.put(remainder, pos++);

            quotient = remainder*10 / lDenominator;
            remainder = remainder*10 % lDenominator;
            sb.append(quotient);
            if (remainder == 0) {
                break;
            }
        }
        if (remainder == 0) {
            return sb.toString();
        }
        sb.insert(pos, "(");
        sb.append(")");
        return sb.toString();
    }
}
