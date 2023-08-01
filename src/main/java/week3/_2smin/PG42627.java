package week3._2smin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG42627 {

    public static void main(String[] args) {
        int[][] input = {{0, 3}, {1, 9}, {2, 6}};
        int result = Solution.solution(input);
        System.out.println(result);
    }
}


class Solution {
    public static int solution(int[][] jobs) {

        int time = 0;

        int count = 0;
        Arrays.sort(jobs,(o1, o2) -> o1[0] - o2[0]);
        //disk controller의 작업 큐 (순서가 정해진것만)
//        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        //작업을 다 꺼낼때까지...????
        int sum = 0; // 각 작업의 요청부터 걸린시간의 합
        while(count < jobs.length || !queue.isEmpty()){

            //현재시점에서 가능한 작업을 꺼내온다.
            //프로세스가 놀고있으면 먼저 하되, 안놀고 있으면 가능한걸 다 꺼내온다.

            while(count < jobs.length && jobs[count][0] <= time){ //현재 가능한 작업이 있으면 모조리
                queue.offer(jobs[count++]); //프로세스에 해당 작업을 넣는다
            }

            //프로세스가 놀고 있는 경우
            if(queue.isEmpty()){
                time = jobs[count][0]; //다음 job을 실행 가능한 시간으로 올린다.
            }else{ //할일이 있으면
                int[] nextJob = queue.poll(); //프로세스를 실행한다
                sum += time - nextJob[0] + nextJob[1]; //현재시간 - 요청시간 + 실행시간 (현재 작업의 요청부터 수행까지 걸린시간)
                time += nextJob[1]; //프로세스 수행에 걸린시간만큼 현재 시간을 올린다
            }

            //꺼내온 작업끼리 비교해서 그시점에서 평균이 가장 적은 순서 로 첫번째를 queue에 넣는다
            //
        }

        return sum / jobs.length;
        //타임라인을 재면서 시간이 지났는지 확인한다.
    }
}
