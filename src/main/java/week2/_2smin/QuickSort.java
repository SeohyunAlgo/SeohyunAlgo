package week2._2smin;

import java.util.Arrays;

public class QuickSort {

    static int[] arr = new int[8];
    public static void main(String[] args) {



        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }

        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));
        System.out.println();

        sort(0, arr.length-1);
        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));

    }

    public static void sort(int start, int end){

        if(end<=start) return;
        //1. pivot을 left로 잡는다
        int pivot = start;

        int leftIndex = start;
        int rightIndex = end;
        int tmp = 0;
        while(true){
//            System.out.println("left:" + leftIndex + " right: " + rightIndex);
            while(arr[leftIndex] < arr[pivot] && leftIndex < end){
                leftIndex++;
            }

            while(arr[rightIndex] > arr[pivot] && rightIndex > start){
                rightIndex--;
            }

            //left가 pivot보다 크고 right이 pivot보다 작아야 진입 가능

            if(leftIndex < rightIndex){ //left와 right 교체
                tmp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tmp;
                leftIndex++;
                rightIndex--;
                Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));
                System.out.println();
            }else{ //엇갈린 경우 pivot과 swap후 종료
                tmp = arr[rightIndex];
                arr[rightIndex] = arr[pivot];
                arr[pivot] = tmp;
                break;
            }

        }

//        System.out.println("cycle done : pivot: " + arr[rightIndex]);
        Arrays.stream(arr).forEach(Integer -> System.out.print(Integer + " "));
        System.out.println();

        sort(start,rightIndex-1);
        sort(rightIndex+1,end);

    }
}
