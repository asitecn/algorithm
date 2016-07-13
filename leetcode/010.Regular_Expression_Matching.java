public class Solution {
    public boolean isMatch(String s, int is, String p, int ip) {
        while(ip < p.length()) {
            char cp = p.charAt(ip);
            if (ip < p.length() - 1 && p.charAt(ip+1) == '*') {
                if (isMatch(s, is, p, ip+2)) {
                    return true;
                }
            } else {
                ip++;
            }

            if (is == s.length() || cp != s.charAt(is) && cp != '.') {
                return false;
            }
            is++;
        }
        return (is == s.length());
    }
    
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
}
