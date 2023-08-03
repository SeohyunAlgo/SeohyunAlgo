package week3._2smin;

import java.util.*;

public class PG42678 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] answer = solution.solution(arr);

        Arrays.stream(answer).forEach(System.out::println);

    }

     static class Solution {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            for(String exp : operations){
                execute(exp);
            }

            answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.poll();
            answer[1] = minQueue.isEmpty() ? 0 : minQueue.poll();

            return answer;
        }


        public void execute(String exp){
            if(exp.equalsIgnoreCase("D 1")){
                //최대값 반환
                if(!maxQueue.isEmpty()){
                    int num = maxQueue.poll();
                    minQueue.remove(num);
                }
            }else if(exp.equalsIgnoreCase("D -1")){
                //최솟값 반환
                if(!minQueue.isEmpty()){
                    int num = minQueue.poll();
                    maxQueue.remove(num);
                }
            }else{
                //넣기
                int num = Integer.valueOf(exp.substring(2));
                minQueue.offer(num);
                maxQueue.offer(num);
            }

        }
    }
}

