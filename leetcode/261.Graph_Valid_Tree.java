// Solution 1, union-find, 2ms
public class Solution {

    int[] father;
    public boolean validTree(int n, int[][] edges) {
        father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++) {
            if (find(edges[i][0]) == find(edges[i][1])) {
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (father[i] == i) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        
        return true;
    }
    
    public int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    
    public void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }

}


// Solution 2, dfs, 15ms
public class Solution {
    public void dfs(Map<Integer, List<Integer>> adjlist, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> neighbors = adjlist.get(node);
        for(Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(adjlist, visited, neighbor);
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjlist = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjlist.put(i, new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                if (count >= 2) {
                    return false;
                }
                dfs(adjlist, visited, i);
            }
        }
        return edges.length == n - 1;
    }
}
