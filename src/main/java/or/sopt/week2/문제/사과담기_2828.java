package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 사과담기_2828 {

    /**
     * 진짜 세세한 것도 잘 신경써야한다.
     *
     * 칸수가 네 칸이면
     * start포인터가 end포인터까지 움직이는 거리는 3이다
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵의 크기
        int N = Integer.parseInt(st.nextToken());

        // 바구니의 크기
        int M = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = M;
        int result = 0;

        int cnt = Integer.parseInt(br.readLine());
        for (int i=0; i<cnt; i++){
            int apple = Integer.parseInt(br.readLine());

            // 사과가 시작점보다 작은 경우
            if (apple<start){
                // result는 사과의 현재 위치에서 시작점을 뺀 값 -> 즉 이동한 거리가 된다
                result += start-apple;
                start = apple;

                // M+1과 M-1을 반드시 해줘야한다.
                end = start+M-1;
            }

            // 사과가 끝점보다 큰 경우
            if (apple>end){
                result += apple - end;
                end = apple;
                start = end - M+1;
            }

            // 그게 아니면 그냥 가만히 있으면 됨
        }

        System.out.println(result);
    }
}
