import java.util.*;
public class NextPermutation {
    
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void nextPermutation(int[] num) {
        //  1,2,3 → 1,3,2
        //  1,3,2 → 2,1,3
        //  2,1,3 → 2,3,1
        //  2,3,1 → 3,1,2
        //  3,1,2 → 3,2,1
        
        if (num == null || num.length < 2) {
            return;
        }
        
        boolean swapMode = true;
        int last = num.length-1;
        for(int i = num.length-2; i >= 0; i--) {
            if (num[last] > num[i]) {
                if (swapMode) {
                    System.out.println("swap");
                    swap(num, i, last);
                    return;
                } else {
                    last = i;
                    System.out.println("break");
                    break;
                }
            } else {
                last = i;
            }
            swapMode = false;
        }
        // 1,4,3,2 -> 2,1,3,4
        // 2,4,3,1 -> 3,1,2,4
        if (last == 0) {
            Arrays.sort(num);
        } else {
            int minNext = 1;
            for(int i = last; i < num.length; i++) {
                if (num[last] < num[i]) {
                    if (num[i] < num[minNext]) {
                        minNext = i;
                    }
                }
            }
            System.out.println("minNext=" + minNext + ",last=" + last);
            swap(num, last, minNext);
            Arrays.sort(num, last+1, num.length);
        }
    }

    public void print(int[] num) {
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        NextPermutation np = new NextPermutation();
        int[] num = new int[] {3, 2, 1};
        np.print(num);
        np.nextPermutation(num);
        np.print(num);
    }
}
