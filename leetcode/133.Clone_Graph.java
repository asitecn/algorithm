/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        
        UndirectedGraphNode clonedHead = new UndirectedGraphNode(node.label);
        visited.put(node.label, clonedHead);

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            node = queue.poll();
            UndirectedGraphNode cloned = visited.get(node.label);
            for(UndirectedGraphNode neighbor : node.neighbors) {
                UndirectedGraphNode clonedNeighbor = visited.get(neighbor.label);
                if (clonedNeighbor == null) {
                    queue.offer(neighbor);
                    clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor.label, clonedNeighbor);
                } 
                cloned.neighbors.add(clonedNeighbor);
            }
        }
        return clonedHead;
    }
}
