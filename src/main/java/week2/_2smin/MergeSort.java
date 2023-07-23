package week2._2smin;

import java.util.Arrays;

public class MergeSort {

    static int[] sorted = new int[20];

    public static void main(String[] args) {

        int[] arr = new int[8];

        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }

        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));
        System.out.println();

        divide(arr, 0, arr.length-1);

        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));


    }

    public static void divide(int[] arr, int left, int right){


        if(left < right){
            int middle = (left+right)/2;
            divide(arr, left, middle);
            divide(arr, middle+1, right);
            merge(arr, left, right);
        }
    }

    public static void merge(int[] arr, int left, int rightEnd){
        System.out.println("left: " + left + " right: " + rightEnd);
        int leftStart = left;
        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd+1;
        int index = leftStart;
        while(leftStart <= leftEnd && rightStart <= rightEnd){
            if (arr[leftStart] < arr[rightStart]){
                sorted[index] = arr[leftStart];
                leftStart++;
            }else{
                sorted[index] = arr[rightStart];
                rightStart++;
            }
            index++;
        }

        if(leftStart > leftEnd) {
            for (int i = rightStart; i <= rightEnd; i++) {
                sorted[index] = arr[i];
                index++;
            }
        }else{
            for (int i = leftStart; i <= leftEnd; i++) {
                sorted[index] = arr[i];
                index++;
            }
        }

        for(int i=left; i<=rightEnd; i++){ //기존 left 와 rightEnd로 진행해야함
            arr[i] = sorted[i];
        }

        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));
        System.out.println();
        System.out.println();
    }

}
