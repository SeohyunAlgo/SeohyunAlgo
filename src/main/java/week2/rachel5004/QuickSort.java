package week2.rachel5004;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static int partitionWithRecursion(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        // 엇갈리지 않으면 계속 반복
        while (left <= right) { // 중복값이 들어가는 경우는 <=

            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            // 엇갈리지 않으면 swap
            if (left <= right) { // 2. 1과 동일
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
