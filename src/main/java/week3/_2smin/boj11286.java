package week3._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            if(Math.abs(a)==Math.abs(b)) {
                return a-b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        }
    });
    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        for(int i=0; i<total; i++) {
            int num = Integer.valueOf(bf.readLine());
            execute(num);
        }

        System.out.println(sb.toString());

    }

    public static void execute(int num){
        if(num == 0){
            if(queue.size() > 0){
                sb.append(queue.poll()).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }else{
            queue.offer(num);
        }
    }

}
