package week2.pjnw1236;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShellSort {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{160, 150, 140, 130, 120, 110, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

        ArrayList<Integer> gaps = new ArrayList<>(); // [8, 4, 2, 1]
        int gap = arr.length/2;
        while (true) {
            gaps.add(gap);
            if (gap == 1) {
                break;
            }
            gap/=2;
        }

        System.out.println(Arrays.toString(arr));
        for (int i=0; i<gaps.size(); i++) {
            printShellSortProcess(arr, gaps.get(i));
        }
        /*
        [160, 150, 140, 130, 120, 110, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10]
        [80, 150, 140, 130, 120, 110, 100, 90, 160, 70, 60, 50, 40, 30, 20, 10]
        [80, 70, 140, 130, 120, 110, 100, 90, 160, 150, 60, 50, 40, 30, 20, 10]
        [80, 70, 60, 130, 120, 110, 100, 90, 160, 150, 140, 50, 40, 30, 20, 10]
        [80, 70, 60, 50, 120, 110, 100, 90, 160, 150, 140, 130, 40, 30, 20, 10]
        [80, 70, 60, 50, 40, 110, 100, 90, 160, 150, 140, 130, 120, 30, 20, 10]
        [80, 70, 60, 50, 40, 30, 100, 90, 160, 150, 140, 130, 120, 110, 20, 10]
        [80, 70, 60, 50, 40, 30, 20, 90, 160, 150, 140, 130, 120, 110, 100, 10]
        [80, 70, 60, 50, 40, 30, 20, 10, 160, 150, 140, 130, 120, 110, 100, 90]
        [40, 70, 60, 50, 80, 30, 20, 10, 120, 150, 140, 130, 160, 110, 100, 90]
        [40, 30, 60, 50, 80, 70, 20, 10, 120, 110, 140, 130, 160, 150, 100, 90]
        [40, 30, 20, 50, 80, 70, 60, 10, 120, 110, 100, 130, 160, 150, 140, 90]
        [40, 30, 20, 10, 80, 70, 60, 50, 120, 110, 100, 90, 160, 150, 140, 130]
        [20, 30, 40, 10, 60, 70, 80, 50, 100, 110, 120, 90, 140, 150, 160, 130]
        [20, 10, 40, 30, 60, 50, 80, 70, 100, 90, 120, 110, 140, 130, 160, 150]
        [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160]
         */
    }

    public static void printShellSortProcess(int[] arr, int gap) {
        for (int i=0; i<gap; i++) {
            List<Integer> targets = new ArrayList<>();
            for (int j=i; j<arr.length; j+= gap) {
                targets.add(j);
            }
            customInsertionSort(arr, targets);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void customInsertionSort(int[] arr, List<Integer> targets) {
        int n = targets.size();
        int[] subArr = new int[n];
        for (int i=0; i<n; i++) {
            subArr[i] = arr[targets.get(i)];
        }

        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (subArr[j] > subArr[j+1]) {
                    int tmp = subArr[j];
                    subArr[j] = subArr[j+1];
                    subArr[j+1] = tmp;
                }
            }
        }

        for (int i=0; i<n; i++) {
            arr[targets.get(i)] = subArr[i];
        }
    }
}
