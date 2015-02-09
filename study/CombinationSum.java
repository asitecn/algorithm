import java.util.*;
public class CombinationSum {
    
    List<List<Integer>> results = new LinkedList<>();
    
    public void combinationSum(int[] candidates, int index, int target, LinkedList<Integer> result) {
        if (target == 0) {
            results.add(new LinkedList<Integer>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            result.add(candidates[i]);
            combinationSum(candidates, i, target-candidates[i], result);
            result.removeLast();
        }
    }

    public void print(List<List<Integer>> results) {
        for(List<Integer> result : results) {
            for(Integer str : result) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // For example, given candidate set 2,3,6,7 and target 7,
        // A solution set is:
        // [7]
        // [2, 2, 3] 
        LinkedList<Integer> result = new LinkedList<>();
        combinationSum(candidates, 0, target, result);
        return results;
    }

    public static void main(String args[]) {
        int[] candidates = new int[]{1, 2};
        int target = 3;
        CombinationSum c = new CombinationSum();
        List<List<Integer>> result = c.combinationSum(candidates, target);
        c.print(result);
    }
}
