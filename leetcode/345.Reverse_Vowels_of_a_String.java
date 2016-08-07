public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] ch = s.toCharArray();
        Set<Character> isVowel = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < s.length() && !isVowel.contains(s.charAt(i))) {
                i++;
            }
            while(j >= 0 && !isVowel.contains(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                char c = ch[i];
                ch[i] = ch[j];
                ch[j] = c;
            }
            i++;
            j--;
        }
        return new String(ch);
    }
}
