public class Solution {

    public boolean isAdditiveNumber(String num, long num1, long num2, int pos) {
        if (pos == num.length()) {
            return false;
        }
        for(int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }
            long num3 = Long.parseLong(num.substring(pos, i+1));
            //System.out.println(num1 + "\t" + num2 + "\t" + num3);
            if (num3 == num1 + num2) {
                if (i == num.length() - 1) {
                    return true;
                }
                pos = i+1;
                num1 = num2;
                num2 = num3;
            } else if (num3 > num1 + num2) {
                return false;
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i != 0) {
                break;
            }
            int len_i = (i+1);
            long num1 = Long.parseLong(num.substring(0, len_i));
            for(int j = i+1; j <= num.length() - Math.max(len_i, j - i); j++) {
                if (num.charAt(i+1) == '0' && j != i+1) {
                    break;
                }                
                long num2 = Long.parseLong(num.substring(i+1, j+1));
                //System.out.println(num1 + "\t" + num2);
                if (isAdditiveNumber(num, num1, num2, j+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
