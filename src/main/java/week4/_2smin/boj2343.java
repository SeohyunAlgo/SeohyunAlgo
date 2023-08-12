package week4._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class boj2343 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int total = 0;
    static int blueRay = 0;

    static int[] videos;
    public static void main(String[] args) throws IOException {

        String[] settings = String.valueOf(bf.readLine()).split(" ");
        total = Integer.valueOf(settings[0]);
        videos = new int[total];

        blueRay = Integer.valueOf(settings[1]);

        String[] videoSizes = String.valueOf(bf.readLine()).split(" ");

        for(int i=0; i<total; i++){
            videos[i] = Integer.valueOf(videoSizes[i]);
        }

        int min = Arrays.stream(videos).max().getAsInt();
        int max = IntStream.range(0, videos.length).map(index -> videos[index]).sum();

        check(min,max);


    }

    public static void check(int start, int end){

        while(start <= end){
            int mid = (start+end)/2;

            int cap = 0;
            int cnt = 0;
            for(int i=0; i<total; i++){

                if(cap+videos[i] > mid){
                    cap = 0;
                    cnt++;
                }
                cap += videos[i];
            }

            if(cap != 0){
                cnt++;
            }

            if(cnt > blueRay){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(start);
    }

}
