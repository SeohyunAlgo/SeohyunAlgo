package week3._2smin;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    static int size = 10;
    static int[] unsorted = new int[size];
    static List<Integer> sorted = new ArrayList<>();
    static List<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {


        for(int i=0; i<unsorted.length; i++){
            unsorted[i] = (int)(Math.random()*100);
        }

        System.out.println("unsorted : " + unsorted);

        for(int i=0; i< unsorted.length; i++){
            heap.add(unsorted[i]);
        }

        //최소 힙 만들기
        createHeap();
        //최소값 제거하면서 힙 재구성
        heapify();

        System.out.println("sorted : " + sorted);
    }

    public static void heapify(){
        for(int i=heap.size()-1; i>=0; i--){
            int ext = heap.get(0);
            sorted.add(ext);
            heap.set(0,heap.get(i));
            heap.remove(i);
            heapFromHead();
        }
    }

    public static void heapFromHead(){
        int i = 0;
        while(i < heap.size()){
            int left = i*2+1;
            int right = i*2+2;
            if(right>=heap.size()) break;

            int index = 0;
            int tmp = 0;

            index = heap.get(left) < heap.get(right) ?  left : right;

            if (heap.get(i) > heap.get(index)) {
                tmp = heap.get(index);
                heap.set(index,heap.get(i));
                heap.set(i,tmp);
            }

            i = index;
        }
    }

    public static void createHeap(){

        //n/2의 몫이 자신의 부모 노드이다. 일단 뒤에 넣고 부모노드랑 계속 교환
        for(int s=heap.size()-1; s>=1; s--){
            int index = s;
            while(index!=0){
                if(heap.get(index) < heap.get((index-1)/2)){
                    int tmp = heap.get(index);
                    heap.set(index,heap.get((index-1)/2));
                    heap.set((index-1)/2,tmp);
                }
                index = (index-1)/2;
            }
        }
    }
}
