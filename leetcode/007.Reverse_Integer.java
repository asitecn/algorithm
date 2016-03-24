public class Solution {
    public int reverse(int x) {
        // Example1: x = 123, return 321
        // Example2: x = -123, return -321
        
        if (x == 0) {
            return 0;
        }
        int sign = (x > 0 ? 1 : -1);
        x *= sign;
        long y = 0;
        while(x > 0) {
            y = y*10 + (x%10);
            x/=10;
        }
        y *= sign;
        if (y > 0) {
            return (y > Integer.MAX_VALUE ? 0 : (int)y);
        } else {
            return (y < Integer.MIN_VALUE ? 0 : (int)y);
        }
    }
}
