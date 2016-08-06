public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int end = 0;
        int counter = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int minStart = 0;
        int maxLen = Integer.MIN_VALUE;
        while (end < s.length()) {
            {
                char ce = s.charAt(end++);
                Integer val = map.get(ce);
                map.put(ce, val == null ? 1 : val + 1);
                if (val == null || val == 0) {
                    counter++;
                }
            }
            
            while(counter >= 3) {
                char cs = s.charAt(start++);
                Integer val = map.get(cs);
                map.put(cs, val - 1);
                if (val == 1) {
                    counter--;
                }
            }
            
            if (maxLen < end - start) {
                minStart = start;
                maxLen = end - start;
            }                
        }
        
        return (maxLen == Integer.MIN_VALUE ? 0 : maxLen);
        
    }
}
