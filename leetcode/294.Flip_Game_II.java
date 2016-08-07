public class Solution {
    public boolean canWin(StringBuilder sb) {
        for(int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i+1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                if (!canWin(sb.toString())) {
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i+1, '+');
            }
        }
        return false;
    }
    
    public boolean canWin(String s) {
        return canWin(new StringBuilder(s));
    }
}
