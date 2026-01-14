package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 교수_2트_3474 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 2의 배수를 찾고
        for (int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            // 홀수
            int a_cnt = 0;
            // 짝수
            int b_cnt = 0;
            int result = 0;

            for (int j=2; j<=input; j*=2){
                a_cnt += (input/j);
            }

            for (int k=5; k<=input; k*=5){
                b_cnt += (input/k);
            }

            result = Math.min(a_cnt,b_cnt);
            sb.append(result).append("\n");
        }

        System.out.print(sb);

    }
}
