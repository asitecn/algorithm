// yet to understand

public class Solution {
    public boolean isMatch(String str, String pattern) {
/*
        Some examples:
        isMatch("aa","a") → false
        isMatch("aa","aa") → true
        isMatch("aaa","aa") → false
        isMatch("aa", "*") → true
        isMatch("aa", "a*") → true
        isMatch("ab", "?*") → true
        isMatch("aab", "c*a*b") → false        
*/
        
        int s = 0, p = 0, smatch = 0, pmatch = -1;
        // match is for backtracking, where was last match;
        while (s < str.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                // save matched position, for backtracking
                pmatch = p;
                smatch = s;
                p++;
            } else if (pmatch != -1) {
                // else check if '*' showed up before, if so, backtracking to previous position
                p = pmatch + 1;
                s = ++smatch;
            } else {
                return false;
            }
        }
        
        while(p < pattern.length()) {
            if (pattern.charAt(p++) != '*') {
                return false;
            }
        }
        
        return true;
    }
    
}
