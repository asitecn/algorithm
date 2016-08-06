public class Solution {
    public boolean isValidChar(char c) {
        if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)('a' + (c - 'A'));
        }
        return c;
    }
    
    public boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length() - 1;
        while(i < j) {
            char c1 = s.charAt(i);
            if (!isValidChar(c1)) {
                i++;
                continue;
            }
            char c2 = s.charAt(j);
            if (!isValidChar(c2)) {
                j--;
                continue;
            }
            if (toLower(c1) != toLower(c2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
