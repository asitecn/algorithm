public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]. 
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        List<Integer> list = new LinkedList<>();
        for(int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                Integer value = map.get(num);
                if (value == 1) {
                    map.remove(num);
                } else {
                    map.put(num, value - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
