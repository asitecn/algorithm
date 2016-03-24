public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int idx = 0;
        while(idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }
        
        int sign = (str.charAt(idx) == '-' ? -1 : 1);
        int start = (str.charAt(idx) == '-' || str.charAt(idx) == '+' ? idx+1 : idx);

        long value = 0; 
        for(int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
            value = value*10 + (str.charAt(i) - '0');
            if (value > Integer.MAX_VALUE) {
                break;
            }
        }
        
        value *= sign;
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } 
        return (int) value;
    }
}
