public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
//        For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

        int i = 0;
        int j = 31;
        while(i < j) {
            int low = (n >> i) & 1;
            int high = (n >> j) & 1;
            if (low != high) {
                n ^= ((1 << i) | (1 << j));
            }
            i++;
            j--;
        }
        return n;
    }
}
