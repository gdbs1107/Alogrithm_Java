package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;


/**
 * 헬퍼메서드를 사용하는 것을 두려워하지 말자 -> 이 문제 꼭 다ㅣㅅ 풀어보자
 * */
public class NBA_2트_2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int lastLeadChangeTime = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;

        int endTime = 60 * 48;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 팀과 시간을 계산한다 -> 이렇게 시간을 다루는 문제는 초단위로 계산하는게 간편하다
            int team = Integer.parseInt(st.nextToken());
            String[] strTime = st.nextToken().split(":");
            int scoreTime = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);

            // 이기고 있는 팀을 확인하고 leadTime에 이전에 득점시간과 현재 득점시간을 뺀 값을 더한다
            if (score1 > score2) {
                leadTime1 += scoreTime - lastLeadChangeTime;
            } else if (score2 > score1) {
                leadTime2 += scoreTime - lastLeadChangeTime;
            }

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            lastLeadChangeTime = scoreTime;
        }

        // 끝에 남은 시간 계산하는 로직
        if (score1 > score2) {
            leadTime1 += endTime - lastLeadChangeTime;
        } else if (score2 > score1) {
            leadTime2 += endTime - lastLeadChangeTime;
        }

        // 시간과 분으로 나누는 로직
        int min1 = leadTime1 / 60;
        int sec1 = leadTime1 % 60;
        int min2 = leadTime2 / 60;
        int sec2 = leadTime2 % 60;
        bw.write(String.format("%02d:%02d\n", min1, sec1));
        bw.write(String.format("%02d:%02d\n", min2, sec2));
        bw.flush();
    }
}
