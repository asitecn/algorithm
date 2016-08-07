public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        Map<String, Queue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if (map.get(ticket[0]) == null) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String city = stack.peek();
            Queue<String> neighbors = map.get(city);
            if (neighbors == null || neighbors.isEmpty()) {
                res.add(stack.pop());
            } else {
                stack.push(neighbors.poll());
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}
