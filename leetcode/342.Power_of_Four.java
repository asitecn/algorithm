public class Solution {
    public boolean isPowerOfFour(int num) {
        /*
        while (num >= 4) {
            if ((num & 3) > 0) {
                return false;
            }
            num >>= 2;
        }
        return (num == 1);
        */
        
        int mask = 0x55555555;
        return (num > 0 && (num & mask) == num && (num & (num-1)) == 0);
    }
}
