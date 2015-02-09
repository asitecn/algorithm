public class Atoi {
    public static int atoi(String str) {
        if (str == null) {
            return 0;
        }
        
        // Input:   " -0012a42"

        Long result = 0L;
        boolean isSignSet = false;
        int sign = 1;
        int idx = 0;
        while(idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }
        for(int i = idx; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (isSignSet) {
                    return 0;
                }
                isSignSet = true;
                sign = (c == '+' ? 1 : -1);
                System.out.println(sign);
            } else if (c >= '0' && c <='9') {
                result = result*10 + (int)(c-'0');
                if (sign*result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign*result <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        System.out.println(result);
        result *= sign;
        System.out.println(result);
        return result.intValue();
    }

    public static void main(String args[]) {
        System.out.println(Atoi.atoi("9223372036854775809"));
    }
}
