public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rev = x / mid;
            if (rev == mid) {
                return mid;
            }
            if (rev < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
