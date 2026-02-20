package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b_4153 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){

            String input = br.readLine();
            if (input.equals("0 0 0")) break;

            StringTokenizer st = new StringTokenizer(input);
            int[] arr = new int[3];
            int max = 0;
            int flag = 0;

            // 배열 만들기
            for (int i=0; i<3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 제일 큰값 찾기
            for (int i=0; i<3; i++){
                if (arr[i]>max){
                    flag = i;
                    max = arr[i];
                }
            }

            int sum = 0;
            // 직각 판별하기
            for (int i=0; i<3; i++){
                if (i==flag){
                    max = max*max;
                }else{
                    sum = sum+(arr[i]*arr[i]);
                }
            }

            if (max == sum) {
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }

}
