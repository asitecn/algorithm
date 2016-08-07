public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return true;
        }
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            boolean containsPattern = patternMap.containsKey(c);
            boolean containsStr = strMap.containsKey(s);
            if (containsPattern != containsStr) {
                return false;
            }
            if (!containsPattern) {
                patternMap.put(c, s);
                strMap.put(s, c);
            } else {
                if (!s.equals(patternMap.get(c)) || c != strMap.get(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}
