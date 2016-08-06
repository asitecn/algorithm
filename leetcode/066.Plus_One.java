public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            if (val < 10) {
                digits[i] = val;
                return digits;
            }
            digits[i] = val - 10;
        }

        // carry must be greater than 0
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[0] = carry;
        return result;
    }
}
