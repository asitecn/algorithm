public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        
        boolean found = false;
        for(Map.Entry<Character, Integer> me : map.entrySet()) {
            if (me.getValue() % 2 == 1) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }
}
