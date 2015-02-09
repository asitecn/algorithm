import java.util.*;
public class PermuteII {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permute(result, current, num, visited);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> current, int[] num, boolean[] visited) {
        if (current.size() == num.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                if (i > 0 && num[i] == num[i-1] && visited[i-1]) {
                    return;
                }
                visited[i] = true;
                current.add(num[i]);
                permute(result, current, num, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
   
    public void print(List<List<Integer>> results) {
        for(List<Integer> result : results) {
            for(Integer val : result) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        PermuteII p = new PermuteII();
//        int num[] = {3, 2, 2, 1, 1, 1};
        int num[] = {3, 2, 1, 1};
        List<List<Integer>> result = p.permuteUnique(num);
        p.print(result);
    }
}
