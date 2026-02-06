package or.sopt.기초.week1.unsolved;

import java.util.*;
import java.io.*;

// 그냥 아예 접근도 안된다 뭐라는건지 모르겠음
public class b_1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());


        // 대각선 내부 칸의 개수
        int cross_count = 1;
        // 이전 대각선들을 포함한 총 칸의 개수
        int prev_count_sum = 0;

        while (true) {
            // 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
            if (X <= prev_count_sum + cross_count) {

                if (cross_count % 2 == 1) {	// 대각선의 개수가 홀수라면
                    // 분자가 큰 수부터 시작
                    // 분자는 대각선상 블럭의 개수 - (X 번째 - 직전 대각선까지의 블럭 개수 - 1)
                    // 분모는 X 번째 - 직전 대각선까지의 블럭 개수
                    System.out.print((cross_count - (X - prev_count_sum - 1)) + "/" + (X - prev_count_sum));
                    break;
                }

                else {	// 대각선의 개수가 짝수라면
                    // 홀수일 때의 출력을 반대로
                    System.out.print((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum - 1)));
                    break;
                }

            } else {

                // 대각선 내부의 칸의 개수를 계속 더해가며 칸의 개수를 늘리는거임 -> 피보나치 수열
                prev_count_sum += cross_count;
                cross_count++;
            }
        }
    }
}
