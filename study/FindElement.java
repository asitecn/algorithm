public class FindElement {

    public boolean findElement(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && i >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    public boolean findElementBinary(int[][] matrix, int target, int i1, int j1, int i2, int j2) {
        if (i1 > i2 || j1 > j2) {
            return false;
        }
        int mi = i1 + (i2-i1)/2;
        int mj = j1 + (j2-j1)/2;
        if (matrix[mi][mj] == target) {
            return true;
        }
        if (matrix[mi][mj] < target) {
            return findElementBinary(matrix, target, mi+1, mj, i2, j2) || findElementBinary(matrix, target, mi, mj+1, i2, j2);
        }
        return findElementBinary(matrix, target, i1, j1, i2, mj-1) || findElementBinary(matrix, target, i1, mj, mi-1, j2);
    }


    public boolean findElementBinary(int[][] matrix, int target) {
        return findElementBinary(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }


    public static void main(String args[]) {
        FindElement fe = new FindElement();
        int[][] matrix = {
            {15,20,70,85},
            {20,35,80,95},
            {30,55,95,105},
            {40,80,100,120}
        };
        System.out.println(fe.findElement(matrix, 55));
        System.out.println(fe.findElementBinary(matrix, 55));
        System.out.println(fe.findElement(matrix, 54));
        System.out.println(fe.findElementBinary(matrix, 54));
    }

}
