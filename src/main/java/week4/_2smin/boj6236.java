package week4._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class boj6236 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int total;
    static int count;
    static int[] arr;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {

        String[] settings = String.valueOf(bf.readLine()).split(" ");
        total = Integer.valueOf(settings[0]);
        arr = new int[total];
        count = Integer.valueOf(settings[1]);

        for(int i=0; i<total; i++){
           arr[i] = Integer.valueOf(bf.readLine());
        }

        start = Arrays.stream(arr).max().getAsInt();
        end = Arrays.stream(arr).sum();

//        System.out.println("start : "  + start);
//        System.out.println("end : " + end);

        while(start <= end){

//            System.out.println("start : " + start + ", " + "end : " + end);
            int mid = (start + end)/2;

            int currentCnt =0;
            int remained = mid;

//            System.out.println("mid : " + mid);
            for(int i=0; i<total; i++){

                if(remained - arr[i] < 0){
                    currentCnt++;
                    remained = mid;
                }
                remained -= arr[i];
            }

            if(currentCnt < count){
//                System.out.println("currentCount : " + currentCnt);
                end = mid - 1;
            }else {
//                System.out.println("currentCount : " + currentCnt);
                start = mid + 1;
            }
        }

        System.out.println(start);

    }
}
