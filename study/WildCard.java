public class WildCard {

public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        System.out.print(str + "\t" + pattern + "\t");        
        return p == pattern.length();
}

    public boolean isMatch(String s, int is, String p, int ip) {
        if (is == s.length() && ip == p.length()) {
            return true;
        }
        if (ip == p.length()) {
            return false;
        }
        if (is == s.length()) {
            if (ip < p.length()) {
                if (p.charAt(ip) == '*') {
                    return isMatch(s, is, p, ip+1);
                }
            }
            return false;
        }
//        System.out.println(is + "\t" + ip);
        char cs = s.charAt(is);
        char cp = p.charAt(ip);
        if (cp == '*') {
            while(1+ip < p.length() && p.charAt(1+ip) == '*') {
                ip++;
            }
            for(int i = is; i <= s.length(); i++) {
                //System.out.println(i + "\t" + (ip+1));
                if (isMatch(s, i, p, ip+1)) {
                    return true;
                }
            }
            return false;
        }
        if (cp == '?' || cs == cp) {
            return isMatch(s, is+1, p, ip+1);
        }
        return false;
    }    
    
    public boolean isMatch2(String s, String p) {
        /*
            isMatch("aa","a") → false
            isMatch("aa","aa") → true
            isMatch("aaa","aa") → false
            isMatch("aa", "*") → true
            isMatch("aa", "a*") → true
            isMatch("ab", "?*") → true
            isMatch("aab", "c*a*b") → false
        */
        System.out.print(s + "\t" + p + "\t");        
        return isMatch(s, 0, p, 0);
    }

    public static void main(String args[]) {
        WildCard wc = new WildCard();
//        System.out.println(wc.isMatch("a", "aa"));
//        System.out.println(wc.isMatch("aa", "a"));
//        System.out.println(wc.isMatch("aa", "aa"));
//        System.out.println(wc.isMatch("aaa", "aa"));
        System.out.println(wc.isMatch("aa", "*"));
        System.out.println(wc.isMatch("aa", "a*"));
        System.out.println(wc.isMatch("ab", "?b"));
        System.out.println(wc.isMatch("aab", "c*a*b"));
//        System.out.println(wc.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        System.out.println(wc.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}

