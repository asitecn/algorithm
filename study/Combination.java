import java.util.*;
public class Combination {
    List<List<Integer>> results = new LinkedList<>();
    
    public void combine(int[] num, int idx, int k, LinkedList<Integer> result) {
        if (result.size() == k) {
            results.add(new LinkedList<Integer>(result));
            return;
        }
        
        for(int i = idx; i < num.length; i++) {
            result.add(num[i]);
            combine(num, i+1, k, result);
            result.removeLast();
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        int[] num = new int[n];
        for(int i = 0; i <n; i++) {
            num[i] = i+1;
        }
        LinkedList<Integer> result = new LinkedList<>();
        combine(num, 0, k, result);
        return results;
    }

    public void print(List<List<Integer>> results) {
        for(List<Integer> result : results) {
            for(Integer str : result) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        Combination c = new Combination();
        List<List<Integer>> results = c.combine(4,2);
        c.print(results);
    }
}
