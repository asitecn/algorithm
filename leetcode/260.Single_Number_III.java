public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        //xor &= -xor;
        
        for(int i = 0; i < 32; i++) {
            int shifted = (xor >> i & 1);
            if (shifted == 1) {
                xor = (1 << i);
            }
        }
        
        int[] res = new int[]{0, 0};
        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & xor) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
