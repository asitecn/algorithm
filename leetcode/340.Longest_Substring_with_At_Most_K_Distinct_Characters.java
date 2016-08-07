public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()) {
            char ec = s.charAt(end++);
            map.put(ec, map.containsKey(ec) ? map.get(ec) + 1 : 1);
            while(map.size() > k) {
                char sc = s.charAt(start++);
                map.put(sc, map.get(sc) - 1);
                if(map.get(sc) == 0) {
                    map.remove(sc);
                }
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
