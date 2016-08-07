public class Solution {
    /* union-find 
    
    int[] father;
    
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (father[i] == i) {
                count++;
            }
        }
        return count;
    }
    
    
    public void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
    
    public int find(int node) {
        if (father[node] == node) {
            return node;
        }
        return find(father[node]);
    }
    */
    
    /* dfs */
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }
        
        Map<Integer, List<Integer>> adjmap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjmap.put(i, new ArrayList<Integer>());
        }
        
        for(int[] edge : edges) {
            adjmap.get(edge[0]).add(edge[1]);
            adjmap.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjmap, visited, i);
            }
        }
        return count;
    }    
    
    public void dfs(Map<Integer, List<Integer>> adjmap, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> neighbors = adjmap.get(node);
        for(Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(adjmap, visited, neighbor);
            }
        }
    }
}
