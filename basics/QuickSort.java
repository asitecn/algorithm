public class QuickSort {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = arr[start + (end-start)/2];
        while(i <= j) {
            while(arr[i] < pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr,i++,j--);
            }
        }
        quicksort(arr,start,j);
        quicksort(arr,i,end);
    }

    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    public void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        QuickSort q = new QuickSort();
        
//        int[] arr = {5, 3, 4, 8, 7, 1};
        int[] arr = {24,2,45,20,56,75,2,56,99,53,12};
        q.quicksort(arr);
        q.print(arr);
    }
}
