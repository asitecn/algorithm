public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*
        int count = 0;
        while((n & (n-1)) != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
        */
        
        /*
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;       
        */
        int sum = 0;
        while(n != 0) {
            n = n & (n-1);
            sum++;
        }
        return sum;
    }
}
