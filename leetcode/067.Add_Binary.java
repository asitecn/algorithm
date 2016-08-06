public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int c1 = (i < 0 ? 0 : a.charAt(i--) - '0');
            int c2 = (j < 0 ? 0 : b.charAt(j--) - '0');
            int sum = c1 + c2 + carry;
            if (sum >= 2) {
                sb.insert(0, sum - 2);
                carry = 1;
            } else {
                sb.insert(0, sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
