public class Solution {
    /* swap does not seem to work
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void permuteUnique(List<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length - 1) {
            List<Integer> path = new ArrayList<>();
            for(int i : nums) {
                path.add(i);
            }
            res.add(path);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            swap(nums, pos, i);
            permuteUnique(res, nums, pos+1);
            swap(nums, pos, i);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(res, nums, 0);
        return res;
    }
    */
    
    /*
    // construction
    public void permute(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            // it is a duplicate if two consecutive numbers are the same, and the previous number hasn't been visited.
            // the following conditions are inter-changable
            //if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            permute(res, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(res, path, nums, visited);
        return res;
    } 
    */
  
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public boolean nextPermutation(int[] nums) {
        // 2, 3, 1 | 5, 4
        // 2, 3, 4 | 1, 5
        // find last number that is in decreasing order
        int k = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return false;
        }
        
        int l = k + 1;
        for(int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        
        swap(nums, l, k);
        int i = k+1;
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i++, j--);
        }
        return true;
    }
    
    // permutation sequence
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        do {
            List<Integer> path = new ArrayList<>();
            for(int i : nums) {
                path.add(i);
            }
            res.add(path);
        } while(nextPermutation(nums));

        return res;
    }    
}
