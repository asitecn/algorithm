public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return (s == null && t == null);
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct) {
                    return false;
                }
            }
            if (revMap.containsKey(ct)) {
                if (revMap.get(ct) != cs) {
                    return false;
                }
            }
            map.put(cs, ct);
            revMap.put(ct, cs);
        }
        return true;
    }
}
