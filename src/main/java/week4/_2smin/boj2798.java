package week4._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj2798 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int total;
    static int max;
    static List<Integer> cards = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        String str = String.valueOf(bf.readLine());
        String[] settings = str.split(" ");

        total = Integer.valueOf(settings[0]);
        max = Integer.valueOf(settings[1]);

        String[] cardArr = String.valueOf(bf.readLine()).split(" ");
        for(String card : cardArr){
            cards.add(Integer.valueOf(card));
        }

        getNum();

    }
    private static void getNum(){
        int currentMax = 0;
        for(int i=0; i<cards.size()-2; i++){
            int total = 0;
            for(int j=i+1; j<cards.size()-1; j++){
                for(int k=j+1; k<cards.size(); k++){
                    total = cards.get(i) + cards.get(j) + cards.get(k);
                    if(total <= max){
                        currentMax = Math.max(currentMax, total);
                    }
                }

            }
        }
        System.out.println(currentMax);
    }

}
