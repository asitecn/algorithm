public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> q = new PriorityQueue<int[]>(k, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        for(Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (q.size() < k) {
                q.offer(new int[]{me.getKey(), me.getValue()});
            } else {
                if (me.getValue() > q.peek()[1]) {
                    q.poll();
                    q.offer(new int[]{me.getKey(), me.getValue()});
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(0, q.poll()[0]);
        }
        return res;
    }
}
