package week4._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj16401 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int total;
    static int count;

    static int[] cookies;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        String[] settings = String.valueOf(bf.readLine()).split(" ");
        count = Integer.valueOf(settings[0]);
        total = Integer.valueOf(settings[1]);
        cookies = new int[total];

        String[] sizes = String.valueOf(bf.readLine()).split(" ");

        for(int i=0; i<total; i++){
            cookies[i] = Integer.valueOf(sizes[i]);
        }

         start = 1;
         end = Arrays.stream(cookies).max().getAsInt();
         int answer = 0;
         while(start <= end){

             int mid = (start+end)/2;
             int currentCount = 0;
             for(int i=0; i<total; i++){

                currentCount += cookies[i]/mid;

             }

             if(currentCount >= count){
                 start = mid+1;
                 answer = Math.max(answer,mid);
             }else if (currentCount < count){
                 end = mid-1;
             }

         }

        System.out.println(answer);
    }
}
