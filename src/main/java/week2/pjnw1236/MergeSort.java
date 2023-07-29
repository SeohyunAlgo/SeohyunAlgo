package week2.pjnw1236;

import java.util.Arrays;

public class MergeSort {
    static int[] tmp;

    public static void main(String[] args) {
        int[] arr = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        tmp = new int[arr.length];

        System.out.println(Arrays.toString(arr));
        printMergeSortProcess(arr, 0, arr.length-1);
        /*
        [16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [15, 16, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [15, 16, 13, 14, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [13, 14, 15, 16, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [13, 14, 15, 16, 11, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        [13, 14, 15, 16, 11, 12, 9, 10, 8, 7, 6, 5, 4, 3, 2, 1]
        [13, 14, 15, 16, 9, 10, 11, 12, 8, 7, 6, 5, 4, 3, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 8, 7, 6, 5, 4, 3, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 7, 8, 6, 5, 4, 3, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 7, 8, 5, 6, 4, 3, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 5, 6, 7, 8, 4, 3, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 5, 6, 7, 8, 3, 4, 2, 1]
        [9, 10, 11, 12, 13, 14, 15, 16, 5, 6, 7, 8, 3, 4, 1, 2]
        [9, 10, 11, 12, 13, 14, 15, 16, 5, 6, 7, 8, 1, 2, 3, 4]
        [9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3, 4, 5, 6, 7, 8]
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
         */
    }

    public static void printMergeSortProcess(int[] arr, int left, int right) {
        int mid = (left+right)/2;

        if (left == right) {
            return ;
        }

        printMergeSortProcess(arr, left, mid);
        printMergeSortProcess(arr, mid+1, right);
        sort(arr, left, right);
    }

    public static void sort(int[] arr, int left, int right) {
        int mid = (left+right)/2;
        int l = left;
        int r = mid+1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[idx++] = arr[l++];
            } else {
                tmp[idx++] = arr[r++];
            }
        }

        if (l > mid) {
            for (int i=r; i<=right; i++) {
                tmp[idx++] = arr[i];
            }
        } else if (r > right) {
            for (int i=l; i<=mid; i++) {
                tmp[idx++] = arr[i];
            }
        }

        for (int i=left; i<=right; i++) {
            arr[i] = tmp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
