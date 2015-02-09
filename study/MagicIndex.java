public class MagicIndex {

    public int findMagicIndexD(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;
        if (arr[mid] == mid) {
            return mid;
        }
        if (arr[mid] > mid) {
            // -1, 1, [4], 4, 4, 4
            // 0, 1,  [2], 3, 4, 5
            int idxLeft = findMagicIndexD(arr, start, mid-1);
            int idxRight = arr[mid] < arr.length ? findMagicIndexD(arr, arr[mid], end) : -1;
            return (idxLeft != -1 ? idxLeft : idxRight);
        }
        int idxLeft = arr[mid] >= 0 ? findMagicIndexD(arr, start, arr[mid]) : -1;
        int idxRight = findMagicIndexD(arr, mid+1, end);
        return (idxLeft != -1 ? idxLeft : idxRight);
    }



    public int findMagicIndex(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;
        if (arr[mid] == mid) {
            return mid;
        }
        if (arr[mid] > mid) {
            // 1, 2, [4], 5, 6
            // 0, 1,  [2], 3, 4
            return findMagicIndex(arr, start, mid-1);
        }
            // -1, 0, [1], 5, 6
            // 0, 1, [2], 3, 4
        return findMagicIndex(arr, mid+1, end);
    }


    public int findMagicIndex(int[] arr) {
//        return findMagicIndex(arr, 0, arr.length-1);
        return findMagicIndexD(arr, 0, arr.length-1);
    }

    public static void main(String args[]) {

//        int[] arr = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] arr = new int[]{0, 0, 0, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndex mi = new MagicIndex();
        System.out.println(mi.findMagicIndex(arr));
    }
}
