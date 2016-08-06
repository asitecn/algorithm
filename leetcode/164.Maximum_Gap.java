public class Solution {
    class Pair {
        int min;
        int max;
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    public int maximumGap(int[] nums) {
        
        if (nums.length <= 1) {
            return 0;
        }
        // bucket sort
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        if (min == max) {
            return 0;
        }

        // 1, 2, 3, 100
        // 0, 33, 66, 99 

        int buckets = nums.length;
        int bucketLen = (int)Math.ceil((max - min)*1.0 / buckets);
        Map<Integer, Pair> map = new TreeMap<Integer, Pair>();
        for(int i = 0; i < nums.length; i++) {
            //System.out.println(max + "\t" + min + "\t" + bucketLen);
            int bucketId = (nums[i] - min) / bucketLen;
            Pair pair = map.get(bucketId);
            if (pair == null) {
                map.put(bucketId, new Pair(nums[i], nums[i]));
            } else {
                map.put(bucketId, new Pair(Math.min(pair.min, nums[i]), Math.max(pair.max, nums[i])));
            }
        }
        
        Pair lastPair = null;
        int maxLen = 0;
        for(Map.Entry<Integer, Pair> me : map.entrySet()) {
            Integer bucketId = me.getKey();
            Pair pair = me.getValue();
            if (lastPair != null) {
                maxLen = Math.max(maxLen, pair.max - pair.min);
                maxLen = Math.max(maxLen, pair.min - lastPair.max);
            }
            lastPair = pair;
        }
        
        return maxLen;
    }
}
