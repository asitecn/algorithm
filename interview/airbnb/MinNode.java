import java.util.*;
public class MinNode {

    // nodes from 0 to n-1
    public List<Integer> getMinNode(Map<Integer, List<Integer>> adjlist, int n) {

        Set<Integer> notVisited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            notVisited.add(i);
        }

        for(Map.Entry<Integer, List<Integer>> me : adjlist.entrySet()) {
            Integer pre = me.getKey();
            List<Integer> posts = me.getValue();
        }

        Set<Integer> res = new HashSet<>();
        while(!notVisited.isEmpty()) {
            Integer node = notVisited.iterator().next(); 
            res.add(node);
            dfs(adjlist, node, notVisited, res, node);
        }
        return new ArrayList<>(res);
    }

    public void dfs(Map<Integer, List<Integer>> adjlist, Integer node, Set<Integer> notVisited, Set<Integer> res, Integer root) {
        notVisited.remove(node);
        List<Integer> neighbors = adjlist.get(node); 
        for(Integer neighbor : neighbors) {
            if (notVisited.contains(neighbor)) {
                dfs(adjlist, neighbor, notVisited, res, root);
            }
            if (root != neighbor && res.contains(neighbor)) {
                res.remove(neighbor);
            }
        }
    }


    public void test() {
        Map<Integer, List<Integer>> adjlist = new HashMap<>();
        adjlist.put(0, Arrays.asList(1));
        adjlist.put(1, Arrays.asList(2));
        adjlist.put(2, Arrays.asList(0));

/*
        adjlist.put(0, Arrays.asList(1));
        adjlist.put(1, Arrays.asList(2));
        adjlist.put(2, new ArrayList<>());
*/
        int n = 3;
        List<Integer> res = getMinNode(adjlist, 3);

        for(Integer r : res) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        MinNode n = new MinNode();
        n.test();
    }

}
