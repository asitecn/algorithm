public class Solution {
    public void swap(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
    
    public void reverseWords(char[] s) {
        // Given s = "the sky is blue",
        // return "blue is sky the".
        
        int i = 0;
        while (i < s.length) {
            int start = i;
            while (i < s.length && s[i] != ' ') {
                i++;
            }
            swap(s, start, i - 1);
            i++;
        }
        swap(s, 0, s.length - 1);
    }
}
