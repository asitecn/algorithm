import java.util.;

public class Dict {

    public void buildAdjlistFromTwoWords(Map<Character, Set<Character>> adjlist, String prev, String curr) {
        int i = 0;
        while(i < prev.length() && i < curr.length()) {
            char cp = prev.charAt(i);
            char cc = curr.charAt(i);
            if (cp != cc) {
                adjlist.get(cp).add(cc);
                break;
            }
            i++;
        }
    }

    public void buildAdjlist(Map<Character, Set<Character>> adjlist, List<String> dict) {
        String prev = dict.get(0);
        for(int i = 1; i < dict.size(); i++) {
            String curr = dict.get(i);
            buildAdjlistFromTwoWords(adjlist, prev, curr);
            prev = curr;
        }
    }
    
    public void buildIndegree(Map<Character, Set<Character>> adjlist, Map<Character, Integer> indegree) {
        for(Map.Entry<Character, Set<Character>> me : adjlist.entrySet()) {
            Set<Character> neighbors = me.getValue();
            for(Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.containsKey(neighbor) ? indegree.get(neighbor) + 1 : 1);
            }
        }
    }

    public List<Character> sortDict(List<String> dict) {
        List<Character> res = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return res;
        }
    
        Map<Character, Set<Character>> adjlist = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String s : dict) {
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!adjlist.containsKey(c)) {
                    adjlist.put(c, new HashSet<>());
                    indegree.put(c, 0);
                }
            }
        }        

        buildAdjlist(adjlist, dict);
        buildIndegree(adjlist, indegree);

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> me : indegree.entrySet()) {
            if (me.getValue() == 0) {
                queue.offer(me.getKey());
            }
        }
       
        while(!queue.isEmpty()) {
            Character node = queue.poll();
            res.add(node);
            Set<Character> neighbors = adjlist.get(node);
            for(Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        } 

        return res;
    }

    public void test() {
        //List<String> dict = Arrays.asList("ccda", "ccbk", "cd", "ad", "ab");
        List<String> dict = Arrays.asList("ccda", "ccbk", "cd", "ad", "ab");
        List<Character> res = sortDict(dict);

        for(Character c : res) {
            System.out.print(c + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Dict dict = new Dict();
        dict.test();
    }
}
