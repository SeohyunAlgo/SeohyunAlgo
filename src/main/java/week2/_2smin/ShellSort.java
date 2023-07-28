package week2._2smin;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://planner26.tistory.com/47">Shell Sort Overview of 2smin blog</a>
 */
public class ShellSort {

    static int num = 10;
    static List<Integer> arr = new ArrayList(num);

    public static void main(String[] args) {

        for(int i=0; i<num; i++){
            arr.add((int)(Math.random()*100));
        }

        System.out.println("unsorted : " + arr);

        // 간격을 정하고 해당 간격끼리 sorting 한다
        int div = num;
        while(true){
            //회전마다 간격 나누기
            div = ((div/2)%2) == 0 ? (div/2+1) : (div/2);
            //div 간격으로 삽입정렬 실행
            for(int i=0; i<num; i++){
                for(int j=i; j>=0; j=j-div){
                    if(j-div < 0) break;
                    int temp = 0;
                    if(arr.get(j) < arr.get(j-div)){
                        temp = arr.get(j);
                        arr.set(j, arr.get(j-div));
                        arr.set(j-div,temp);
                    }
                }
            }
            if(div==1) break;
        }

        System.out.println("sorted : " + arr);

    }
}
