package week4._2smin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int line = 0;
    static int max = 0;

    static String[][] arr;
    public static void main(String[] args) throws IOException {

        line = Integer.valueOf(bf.readLine());

        arr = new String[line][line];

        for(int i=0; i<line; i++){
            String str = String.valueOf(bf.readLine());
            String[] row = str.split("");

            for(int j=0; j<line; j++){
                arr[i][j] = row[j];
            }
        }

        //수직 swap
        for(int x=0; x<arr.length-1; x++){
            for(int y=0; y<arr.length; y++){

                if(!arr[x][y].equalsIgnoreCase(arr[x+1][y])){
                    String tmp = arr[x][y];
                    arr[x][y] = arr[x+1][y];
                    arr[x+1][y] = tmp;

                    check();

                    tmp = arr[x][y];
                    arr[x][y] = arr[x+1][y];
                    arr[x+1][y] = tmp;
                }
            }
        }

        //수평 swap
        for(int x=0; x<arr.length-1; x++){
            for(int y=0; y<arr.length; y++){

                if(!arr[y][x].equalsIgnoreCase(arr[y][x+1])){
                    String tmp = arr[y][x];
                    arr[y][x] = arr[y][x+1];
                    arr[y][x+1] = tmp;

                    check();

                    tmp = arr[y][x];
                    arr[y][x] = arr[y][x+1];
                    arr[y][x+1] = tmp;
                }
            }
        }

        System.out.println(max);
    }


    public static void check(){
        int currentMax = 0;


        //수직 검사
        for(int x=0; x<arr.length; x++){

            int count = 1;
            String before = "";
            for(int y=0; y<arr.length; y++){
                String ch = arr[x][y];
                if(before.equalsIgnoreCase(ch)){
                    count++;
                }else{
                    currentMax = Math.max(currentMax,count);
                    before = ch;
                    count=1;
                }
            }
            currentMax = Math.max(currentMax,count);
        }

        //수평 검사
        for(int x=0; x<arr.length; x++){

            int count = 1;
            String before = "";
            for(int y=0; y<arr.length; y++){
                String ch = arr[y][x];
                if(before.equalsIgnoreCase(ch)){
                    count++;
                }else{
                    currentMax = Math.max(currentMax,count);
                    before = ch;
                    count=1;
                }
            }
            currentMax = Math.max(currentMax,count);
        }

        if(currentMax > max){
            max = currentMax;
        }
    }
}
