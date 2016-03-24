public class Solution {
    /* My simple version
    boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int d = s.length();
        while (d > 0) {
            for(int i = 0; i < s.length() - d + 1; i++) {
                if (isPalindrome(s, i, i + d - 1)) {
                    return s.substring(i, i+d);
                }
            }
            d--;
        }
        return "";
    }
    */
    
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
    
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
