public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int i = 0;
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            Integer pos = map.get(c);
            if (pos != null && pos >= i) {
                i = map.get(c) + 1;
            }
            map.put(c, j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        //maxLen = Math.max(maxLen, s.length() - i + 1);
        return maxLen;
    }
}
