package week2.pjnw1236;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 10, 6, 3, 1, 8, 5, 4, 9};

        System.out.println(Arrays.toString(arr));
        printQuickSortProcess(arr, 0, arr.length-1);
        /*
        [7, 2, 10, 6, 3, 1, 8, 5, 4, 9]
        [2, 6, 3, 1, 5, 4, 7, 10, 8, 9]
        [1, 2, 6, 3, 5, 4, 7, 10, 8, 9]
        [1, 2, 3, 5, 4, 6, 7, 10, 8, 9]
        [1, 2, 3, 5, 4, 6, 7, 10, 8, 9]
        [1, 2, 3, 4, 5, 6, 7, 10, 8, 9]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         */
    }

    public static void printQuickSortProcess(int[] arr, int start, int end) {
        if (start >= end) {
            return ;
        }

        int mid = getMid(arr, start, end);
        printQuickSortProcess(arr, start, mid-1);
        printQuickSortProcess(arr, mid+1, end);
    }

    public static int getMid(int[] arr, int start, int end) {
        int pivot = arr[start];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i=start+1; i<=end; i++) {
            if (pivot > arr[i]) {
                left.add(arr[i]);
            } else if (pivot < arr[i]) {
                right.add(arr[i]);
            }
        }

        int idx = start;
        for (int i=0; i<left.size(); i++) {
            arr[idx++] = left.get(i);
        }
        arr[idx++] = pivot;
        for (int i=0; i<right.size(); i++) {
            arr[idx++] = right.get(i);
        }

        System.out.println(Arrays.toString(arr));

        return start + left.size();
    }
}
