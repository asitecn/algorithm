import java.util.*;

public class TwoDimensionArray implements Iterator {

    int m1;
    int n1;
    int m2;
    int n2;
    int dir;
    Integer next;
    boolean isEmpty = false;
    
    int[][] arr;
    int i;
    int j;

    public void init(int[][] arr, int m1, int n1, int m2, int n2) {
        if (m1 > m2 || n1 > n2) {
            isEmpty = true;
            return;
        }

        this.arr = arr;
        this.m1 = m1;
        this.n1 = n1;
        this.m2 = m2;
        this.n2 = n2;
        i = (n1 == n2 ? m1 - 1 : m1);
        j = (n1 == n2 ? n1 : n1 - 1);
        dir = (n1 == n2 ? 1 : 0);
        next = null;
        fetchNext();
    }

    public TwoDimensionArray(int[][] arr) {
        init(arr, 0, 0, arr.length - 1, arr[0].length - 1);
    }

    public void fetchNext() {
        next = null;
       if (n1 == n2) {
            if (i < m2) {
                next = arr[++i][n1];
            } else {
                isEmpty = true;
            }
            return;
        }
        if (m1 == m2) {
            if (j < n2) {
                next = arr[m1][++j];
            } else {
                isEmpty = true;
            }
            return;
        }
 
        //System.out.println("dir=" + dir + ", i=" + i + ", j=" + j);
        if (dir == 0) {
            next = arr[i][++j];
            if (j == n2) {
                dir = 1;
            }
        } else if (dir == 1) {
            next = arr[++i][j];
            if (i == m2) {
                dir = 2;
            }
        } else if (dir == 2) {
            next = arr[i][--j];
            if (j == n1) {
                dir = 3;
            }
        } else {
            next = arr[--i][j];
            if (i == m1) {
                init(arr, m1+1, n1+1, m2-1, n2-1);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (!isEmpty && next != null);
    }

    @Override
    public Integer next() {
        Integer temp = next;
        fetchNext();
        return temp;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1,2,3},
            {6,5,4},
            //{7,6,5}
        };
        TwoDimensionArray two = new TwoDimensionArray(arr);
        while(two.hasNext()) {
            System.out.println(two.next());
        }
    }
}
