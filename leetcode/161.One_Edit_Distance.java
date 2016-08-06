public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (t.length() - s.length() >= 2) {
            return false;
        }
        int is = 0;
        int it = 0;
        boolean found = false;
        while(is < s.length() && it < t.length()) {
            char cs = s.charAt(is);
            char ct = t.charAt(it);
            if (cs != ct) {
                if (found) {
                    return false;
                }
                if (s.length() == t.length()) {
                    is++;
                }
                found = true;
            } else {
                is++;
            }
            it++;
        }
        
        return found || (s.length() < t.length());
    }
}
