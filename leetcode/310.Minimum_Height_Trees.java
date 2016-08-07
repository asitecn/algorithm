public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjlist = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < n; i++) {
            adjlist.put(i, new HashSet<Integer>());
        }
        int[] indegrees = new int[n];

        for(int i = 0; i < edges.length; i++) {
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
            indegrees[edges[i][0]]++;
            indegrees[edges[i][1]]++;
        }

        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            if (indegrees[i] <= 1) {
                q1.add(i);
            }
        }
        int count = n - q1.size();

        while(!q1.isEmpty() & count > 0) {
            Integer node = q1.remove();
            Set<Integer> neighbors = adjlist.get(node);
            for(Integer neighbor : neighbors) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 1) {
                    q2.add(neighbor);
                }
            }
            if (q1.isEmpty()) {
                count -= q2.size();
                if (count == 0) {
                    return new ArrayList<Integer>(q2);
                }
                Queue<Integer> temp = q2;
                q2 = q1;
                q1 = temp;
            }
        }
        return new ArrayList<Integer>(q1);
    }
}
