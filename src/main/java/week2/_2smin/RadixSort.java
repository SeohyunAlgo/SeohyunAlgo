package week2._2smin;

import java.util.*;

public class RadixSort {

    static int num = 10;
    static List<Integer> arr = new ArrayList(num);

    public static void main(String[] args) {

        for(int i=0; i<num; i++){
            arr.add((int)(Math.random()*100));
        }

        System.out.println("unsorted : " + arr);

        int a=0;
        List<Queue<Integer>> table = new ArrayList<>(10);
        while(a++ <10){
            table.add(new LinkedList<>());
        }

        int div = 1;
        int headCounter = num;

        do{
            int head = 0;
            for(Integer num : arr){
                head = (num/div) % 10;
                if(head == 0) headCounter--;
                table.get(head).offer(num);
            }

            arr.clear();

            for(Queue<Integer> queue : table){
                while(!queue.isEmpty()){
                    arr.add(queue.poll());
                }
            }

            div = div*10;

        }while(headCounter!=0);

        System.out.println("sort complete: " + arr);

    }
}
