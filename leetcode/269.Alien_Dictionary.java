public class Solution {
    
    public void addToAdjlist(Map<Character, Set<Character>> adjlist, String prev, String cur) {
        int idx = 0;
        while(idx < prev.length() && idx < cur.length()) {
            char cp = prev.charAt(idx);
            char cc = cur.charAt(idx);
            if (cp != cc) {
                adjlist.get(cp).add(cc);
                break;
            }
            idx++;
        }
    }
    
    public String alienOrder(String[] words) {
        StringBuilder res = new StringBuilder();
        if (words == null || words.length == 0) {
            return res.toString();
        }
        
        Map<Character, Set<Character>> adjlist = new HashMap<>();
        Map<Character, Integer> ind = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!adjlist.containsKey(c)) {
                    adjlist.put(c, new HashSet<>());
                    ind.put(c, 0);
                }
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            addToAdjlist(adjlist, words[i], words[i + 1]);
        }
        //System.out.println(adjlist);

        for(Map.Entry<Character, Set<Character>> me : adjlist.entrySet()) {
            char prevChar = me.getKey();
            for(Character curChar : me.getValue()) {
                ind.put(curChar, ind.get(curChar) + 1);
            }
        }
        //System.out.println(ind);
        
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> me : ind.entrySet()) {
            if (me.getValue() == 0) {
                queue.offer(me.getKey());
            }
        }
        //System.out.println(queue);

        while(!queue.isEmpty()) {
            Character c = queue.poll();
            res.append(c);
            for(Character neighbor : adjlist.get(c)) {
                ind.put(neighbor, ind.get(neighbor) - 1);
                if (ind.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        //return res.toString();
        return res.length() == adjlist.size() ? res.toString() : "";
    }
}
