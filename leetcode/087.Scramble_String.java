public class Solution {
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        char[] ch = new char[26];
        for(int i = 0; i < len; i++) {
            ch[s1.charAt(i) - 'a']++;
            ch[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if (ch[i] != 0) {
                return false;
            }
        }
        

        for(int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) 
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }
        
        return false;
    }
}
