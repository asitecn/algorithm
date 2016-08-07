public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lmap.put(s.charAt(i), i);
        }
        
        Map<Integer, Character> revmap = new TreeMap<>();
        for(Map.Entry<Character, Integer> me : lmap.entrySet()) {
            revmap.put(me.getValue(), me.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(!revmap.isEmpty()) {
            Map.Entry<Integer, Character> me = revmap.entrySet().iterator().next();
            Integer pos = me.getKey();
            Character ch = me.getValue();
            // find the smallest character before ch;
            char min = (char)('z' + 1);
            int minIndex = pos;
            for(int i = index; i <= pos; i++) {
                char c = s.charAt(i);
                if (c < min && lmap.containsKey(c)) {
                    min = c;
                    minIndex = i;
                }
            }
            sb.append(min);
            revmap.remove(lmap.get(min));
            lmap.remove(min);
            index = minIndex + 1;
        }
        return sb.toString();
    }
}
