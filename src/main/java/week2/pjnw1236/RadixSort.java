package week2.pjnw1236;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {300, 20, 1};

        // nums 배열의 원소 중 가장 긴 원소의 길이 구함
        int maxLen = 0;
        for (int num : nums) {
            int numLen = String.valueOf(num).length();
            if (maxLen < numLen) {
                maxLen = numLen;
            }
        }

        // 크기가 10인 각 원소가 ArrayList인 list 생성
        ArrayList<Integer>[] list = new ArrayList[10];
        for (int i=0; i<10; i++) {
            list[i] = new ArrayList<>();
        }

        // Radix Sort 과정 출력
        System.out.println(Arrays.toString(nums));
        for (int i=0; i<maxLen; i++) {
            int d = (int) Math.pow(10, i);
            for (int num : nums) {
                list[num/d%10].add(num);
            }
            // nums 갱신
            int idx = 0;
            for (int j=0; j<10; j++) {
                for (int k=0; k<list[j].toArray().length; k++) {
                    nums[idx++] = list[j].get(k);
                }
            }
            // list 초기화
            for (int l=0; l<10; l++) {
                list[l].clear();
            }

            System.out.println(Arrays.toString(nums));
        }
        /*
        [300, 20, 1]
        [300, 20, 1]
        [300, 1, 20]
        [1, 20, 300]
         */
    }
}
