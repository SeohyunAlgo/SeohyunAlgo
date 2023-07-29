package week2.rachel5004;

import static week2.rachel5004.MergeSort.mergeSort;

public class SortApplication {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10, 153, 262, 37, 598, 433, 855};

        mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
