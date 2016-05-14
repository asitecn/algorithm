import java.util.*;

public class AlienDictionary {
    
    public void buildDependency(String word1, String word2, Map<Character, List<Character>> adjlist, Map<Character, Integer> indegree) {
        int idx = 0;
        while(idx < word1.length() && idx < word2.length()) {
            char c1 = word1.charAt(idx);
            char c2 = word2.charAt(idx);
            if (adjlist.get(c1) == null) {
                adjlist.put(c1, new ArrayList<Character>());
            }
            if (adjlist.get(c2) == null) {
                adjlist.put(c2, new ArrayList<Character>());
            }
            if (c1 != c2) {
                adjlist.get(c1).add(c2);
                System.out.println("" + c1 + "->" + c2);
                indegree.put(c2, indegree.containsKey(c2) ? indegree.get(c2) + 1 : 1);
                break;
            }
            idx++;
        }
    }
    
    public String alienOrder(String[] words) {

        Map<Character, List<Character>> adjlist = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            buildDependency(word1, word2, adjlist, indegree);
        }
        
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, List<Character>> me : adjlist.entrySet()) {
            char c = me.getKey();
            if (!indegree.containsKey(c)) {
                queue.offer(c);
            }
        }
        
        Set<Character> order = new LinkedHashSet<>();
        while(!queue.isEmpty()) {
            Character node = queue.poll();
            /*
            if (order.contains(node)) {
                return "";
            }*/
            order.add(node);
            List<Character> neighbors = adjlist.get(node);
            for(Character neighbor : neighbors) {
                queue.offer(neighbor);
                if (order.contains(node)) {
                    return "";
                }
                Integer in = indegree.get(neighbor);
                if (in != null) {
                    if (in == 1) {
                        indegree.remove(neighbor);
                        System.out.println("adding " + neighbor);
                        queue.offer(neighbor);
                    } else {
                        indegree.put(neighbor, in-1);
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character node : order) {
            sb.append(node);
        }
        return sb.toString();
    }

    public void test() {
        String[] words = new String[]{
            //"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"
            "wrt", "wrf", "er", "ett", "rftt" 
        };
        String s = alienOrder(words);
        System.out.println(s);
    }

    public static void main(String[] args) {
        AlienDictionary alien = new AlienDictionary();
        alien.test();
    }
}
