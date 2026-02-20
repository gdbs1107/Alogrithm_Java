package or.sopt.기초.week1.unsolved;

import java.util.*;
import java.io.*;

public class b_14501 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N];
        int[] p = new int[N];

        StringTokenizer st;
        /*7
        3 10
        5 20
        1 10
        1 20
        2 15
        4 40
        2 200*/
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1]; // 1일에 일한 돈은 2일차에 누적되기 때문
        // 날짜를 진행하면서 해당 날짜에 대한 최대 요금을 저장하는 배열, 각 배열의 인덱스마다 최대 요금을 저장해놓는다.

        for(int i=0; i<N; i++){
            if(i + t[i] <= N) {
                // 날짜가 초과되지 않으면서 해당 날짜에 번 돈을 계산
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            // 오늘 일한 걸 다음날 누적시키기 위한 계산
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
