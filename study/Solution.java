public class Solution {

    public int divide(int dividend, int divisor) {
        // -128 - 127
        // -128 / -1
        if (dividend == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 0) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE && dividend == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 1) {
            return divisor;
        }
        if (dividend == -1) {
            return -divisor;
        }

        int sign = (((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? -1 : 1);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend > divisor) {
            return 0;
        }
        if (dividend == divisor) {
            return sign;
        }
        
        long start = 2;
        long end = divisor;
        long mid = (start + end) >> 1;
        while(start <= end) {
            // 100, 3 => 33    (1+100/2 = 50)
            long result = 0;

	    if (mid > dividend) {
                for(int i = 0; i < dividend; i++) {
        	        result += mid;
            	}
	    } else {
                for(int i = 0; i < mid; i++) {
        	        result += dividend;
            	}
	    }
            if (result == divisor) {
                return (int)(sign == 1 ? mid : -mid);
            } else if (result > divisor) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) >> 1;
        }
        return (int)(sign == 1 ? mid : -mid);
    }
  
    public static void main(String args[]) {
	Solution s = new Solution();
	int result = s.divide(1004958205, -2137325331);
//	int result = s.divide(1004205000, -2137321000);
	System.out.println(result);
   }
}
