public class Solution {
    public int divide(int dividend, int divisor) {
        /*
        if (dividend == 0) {
            return 0;
        }
        long value = (long)dividend / divisor;
        return (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int)value);
        */

        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        int sign = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? 1 : -1);
        long lDividend = Math.abs((long)dividend);
        long lDivisor = Math.abs((long)divisor);

        long sum = 0;
        while (lDividend > 0) {
            long q = 1;
            long val = lDivisor;
            while(val <= lDividend) {
                val <<= 1;
                q <<= 1;
            }
            sum += (q >> 1);
            lDividend -= (val >> 1);
        }
        
        sum = (sign == 1 ? sum : -sum);
        return (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) sum);
    }
}
