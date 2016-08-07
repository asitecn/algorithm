public class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        Map<Character, Integer> m1 = new HashMap<Character, Integer>();
        Map<Character, Integer> m2 = new HashMap<Character, Integer>();
        for(int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                a++;
            } else {
                m1.put(c1, (m1.containsKey(c1) ? m1.get(c1) + 1 : 1));
                m2.put(c2, (m2.containsKey(c2) ? m2.get(c2) + 1 : 1));
            }
        }
        int b = 0;
        for(Map.Entry<Character, Integer> me : m1.entrySet()) {
            Character c1 = me.getKey();
            if (m2.containsKey(c1)) {
                b += Math.min(me.getValue(), m2.get(c1));
            }
        }

        return "" + a + "A" + b + "B";
    }
}
