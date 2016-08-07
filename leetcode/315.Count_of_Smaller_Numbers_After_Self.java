public class Solution {
    class NumberIndex {
        int val;
        int index;
        public NumberIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }
        public String toString() {
            return new Integer(val).toString();
        }
    }
    
    public void countWhileMerge(List<Integer> res, NumberIndex[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = (arr.length - 1) / 2;
        NumberIndex[] left = new NumberIndex[mid+1];
        NumberIndex[] right = new NumberIndex[arr.length - 1 - mid];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid + 1, right, 0, right.length);
        countWhileMerge(res, left);
        countWhileMerge(res, right);
        merge(res, left, right, arr);
    }
    
    public void merge(List<Integer> res, NumberIndex[] left, NumberIndex[] right, NumberIndex[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        while(i < left.length && j < right.length) {
            if (left[i].val > right[j].val) {
                res.set(left[i].index, res.get(left[i].index) + right.length - j);
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i < left.length) {
                arr[k++] = left[i++];
        }
        while(j < right.length) {
                arr[k++] = right[j++];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            res.add(0);
        }
        
        NumberIndex[] arr = new NumberIndex[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = new NumberIndex(nums[i], i);
        }
        
        countWhileMerge(res, arr);
        return res;
    }
}
