public class Solution {
    public int[] countBits(int num) {
        //  For num = 5 you should return [0,1, 1,2, 1,2,2,3, 1,2,2,3,2,3,3,4]. 
        int[] res = new int[num + 1];
        int base = 1;
        for(int i = 0; i <= num; i++) {
            if (i <= 1) {
                res[i] = i;
                continue;
            } 
            if ((i & (i-1)) == 0) {
                base <<= 1;
            }
            res[i] = res[i - base] + 1;
        }
        return res;
    }
}
