import java.util.*;
public class PermSequence {


    private void swapIn(int[] num, int i, int j) {
/*
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
*/
        int temp = num[j];
        for(int k = j; k > i; k--) {
            num[k] = num[k-1];
        }
        num[i] = temp;
    }

    private void swapOut(int[] num, int i, int j) {
        int temp = num[i];
        for(int k = i; k < j; k++) {
            num[k] = num[k+1];
        }
        num[j] = temp;
    }


    int total = 0;
    String result = "";

    public String convert(int[] num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        return sb.toString();
    }

    public void permute(int[] num, int index, int k) {
        if (index == num.length) {
            System.out.println("total="+(total+1)+",k="+k+",result="+convert(num));
            if (++total == k) {
                result = convert(num);
                return;
            }
        }
        for(int i = index; i < num.length; i++) {
            swapIn(num, index, i);
            permute(num, index+1, k);
            swapOut(num, index, i);
            if (total >= k) {
                break;
            }
        }
    }

    public String getPermutation2(int n, int k) {
        int[] num = new int[n];
        for(int i = 0; i < num.length; i++) {
            num[i] = i+1;
        }
        permute(num, 0, k);
        return result;
    }

    public String getPermutation(int n, int k) {
        LinkedList<Integer> num = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            num.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        while(num.size() >= 2) {
            int subsize = factorial(num.size()-1);
            int quotient = k / subsize;
            int index = (k%subsize==0 ? quotient-1 : quotient);
            System.out.println(k/subsize);
            System.out.println("index=" + index + ",k=" + k + ",size=" + num.size() + ",subsize=" + subsize);
            k -= subsize*(quotient-1);
            sb.append(num.get(index));
            num.remove(index);
        }
        sb.append(num.get(0));
        return sb.toString();
    }

    
    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String args[]) {
        PermSequence ps = new PermSequence();
        String res = ps.getPermutation(3, 1);
//        String res = ps.getPermutation(8, 8590);
        System.out.println(res);
    }
}
