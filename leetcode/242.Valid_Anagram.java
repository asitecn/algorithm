public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return (s == null && t == null);
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
