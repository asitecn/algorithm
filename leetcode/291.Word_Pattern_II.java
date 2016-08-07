public class Solution {
    
    // pattern = "abab", str = "redblueredblue" should return true.

    public boolean wordPatternMatch(String pattern, String str, int p, int s, 
            Map<Character, String> patternMap, Map<String, Character> strMap) {
        //System.out.println("patternMap:\t" + Arrays.toString(patternMap.entrySet().toArray()));
        //System.out.println("strMap:\t" + Arrays.toString(strMap.entrySet().toArray()));
        
        if (pattern.length() - p > str.length() - s) {
            return false;
        }

        if (p == pattern.length()) {
            return (s == str.length());
        }
        
        char c = pattern.charAt(p);
        if (patternMap.containsKey(c)) {
            String mapped = patternMap.get(c);
            if (!str.startsWith(mapped, s)) {
                return false;
            }
            return wordPatternMatch(pattern, str, p+1, s+mapped.length(), patternMap, strMap);
        } else {
            for(int j = s; j < str.length(); j++) {
                String newStr = str.substring(s, j+1);
                if (!strMap.containsKey(newStr)) {
                    patternMap.put(c, newStr);
                    strMap.put(newStr, c);
                    if (wordPatternMatch(pattern, str, p+1, j+1, patternMap, strMap)) {
                        return true;
                    }
                    patternMap.remove(c);
                    strMap.remove(newStr);
                }
            }
        }

        return false;
    }
    
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        return wordPatternMatch(pattern, str, 0, 0, patternMap, strMap);
    }
}
