package week1.pjnw1236;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        printSelectionSortProcess(arr);
        /*
        [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [1, 9, 8, 7, 6, 5, 4, 3, 2, 10]
        [1, 2, 8, 7, 6, 5, 4, 3, 9, 10]
        [1, 2, 3, 7, 6, 5, 4, 8, 9, 10]
        [1, 2, 3, 4, 6, 5, 7, 8, 9, 10]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         */
    }

    public static void printSelectionSortProcess(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            int val = arr[i];
            int idx = i;
            for (int j=i+1; j<n; j++) {
                if (val > arr[j]) {
                    val = arr[j];
                    idx = j;
                }
            }
            if (i != idx) {
                int tmp;
                tmp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = tmp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
