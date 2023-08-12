package week3._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2075 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> mainQ;
    static int total = 0;
    public static void main(String[] args) throws IOException {


        total = Integer.valueOf(bf.readLine());
        mainQ = new PriorityQueue<>(total);

        for(int i=0; i<total; i++) {
            String str = String.valueOf(bf.readLine());
            String[] arr = str.split(" ");
            Arrays.stream(arr).forEach(
                    s-> {
                        int num = Integer.valueOf(s);
                        if(mainQ.size() == total){
                            if(mainQ.peek()  < num){
                                mainQ.poll();
                                mainQ.offer(num);
                            }
                        }else{
                            mainQ.offer(num);
                        }
                    }
            );
        }
        int answer = mainQ.peek();
        System.out.println(answer);

    }
}
