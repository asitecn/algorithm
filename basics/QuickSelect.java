public class QuickSelect {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quicksort(int[] arr, int start, int end, int k) {
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

        if (j - start + 1 >= k) {
            quicksort(arr,start,j,k);
        } else {
            // start, 1, 2, 3, 4, ..., j, i, ..., end
            quicksort(arr,i,end, k - (i-start));
        }
    }

    public int quicksort(int[] arr, int k) {
        quicksort(arr, 0, arr.length-1, k);
        return arr[k-1];
    }

    public void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        QuickSelect q = new QuickSelect();
        
//        int[] arr = {5, 3, 4, 8, 7, 1};
        int[] arr = {24,2,45,20,56,75,2,56,99,53,12};
        q.print(arr);
        {
            int value = q.quicksort(arr,3);
            q.print(arr);
            System.out.println(value);
        }
        {
            int value = q.quicksort(arr,5);
            q.print(arr);
            System.out.println(value);
        }
        {
            int value = q.quicksort(arr,10);
            q.print(arr);
            System.out.println(value);
        }
        {
            int value = q.quicksort(arr,11);
            q.print(arr);
            System.out.println(value);
        }
   }
}
