public class Solution {

    /*
        S = "ADOBECODEBANC"
        T = "ABC"
        Minimum window is "BANC". 
    */
    
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetHash = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetHash.put(c, targetHash.containsKey(c) ? targetHash.get(c) + 1 : 1);
        }

        Map<Character, Integer> sourceHash = new HashMap<>();
        int count = 0;
        
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        while(end < s.length()) {
            char ec = s.charAt(end++);
            if (targetHash.containsKey(ec)) {
                sourceHash.put(ec, sourceHash.containsKey(ec) ? sourceHash.get(ec) + 1 : 1);
                if (sourceHash.get(ec) <= targetHash.get(ec)) {
                    count++;
                }
            }
            while(count >= t.length()) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStr = s.substring(start, end);
                }
                char sc = s.charAt(start++);
                if (targetHash.containsKey(sc)) {
                    sourceHash.put(sc, sourceHash.get(sc) - 1);
                    if (sourceHash.get(sc) < targetHash.get(sc)) {
                        count--;
                    }
                }
            }
        }
        
        return minStr;
    }
}
