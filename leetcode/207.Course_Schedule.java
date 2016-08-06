public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjlist.add(new ArrayList<Integer>());
        }
        
        for(int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adjlist.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            count++;
            List<Integer> neighbors = adjlist.get(node);
            for(Integer neighbor : neighbors) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return (count == numCourses);
    }
}
