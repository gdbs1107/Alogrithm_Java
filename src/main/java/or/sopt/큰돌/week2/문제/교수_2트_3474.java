package or.sopt.큰돌.week2.문제;

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

            /**
             * 이게 왜 가능한걸까?
             *
             * j = 2,4,6,8....
             * input = 입력값으로 고정됨
             *
             * 그러니까 입력값을 2로 나눈수 + 4로 나눈수 + 8로 나눈수.... = 총 2의 개수
             * 가 되는거임
             *
             * input = 10으로 예를 들어보면
             * 10/2 = 5
             * 10/4 = 2
             * 10/8 = 1
             * 로 10에 있는 인수 2의 개수는 8개가 되는 것이다 -> 앞으로 인수관련 문제를 풀때는 이렇게 풀어야 시간복잡도 면에서 우수하다고 할 수 있음
             * */
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
