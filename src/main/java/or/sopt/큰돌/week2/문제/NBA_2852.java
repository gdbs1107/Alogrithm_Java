package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

public class NBA_2852 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현재 이기고 있는 사람과 1,2번 팀의 점수
        int is_winner = 0;
        int team_1 = 0;
        int team_2 = 0;

        // 1,2번 팀의 승리 시간
        int team_1_hour = 0;
        int team_1_min = 0;
        int team_2_hour = 0;
        int team_2_min = 0;

        int cur_hour = 0;
        int cur_min = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int winner = Integer.parseInt(st.nextToken());
            String time = st.nextToken();

            if (winner == 1) team_1++;
            if (winner == 2) team_2++;
            int temp;

            if (team_1>team_2) temp = 1;
            else temp = 2;

            // 만약 승자가 이전의 승자와 같지 않다면
            if ( is_winner!=temp ) {

                // 만약 마지막이라면
                if (i==(n-1)){
                    if (temp==1){
                        StringTokenizer st_time = new StringTokenizer(time,":");
                        int hour = Integer.parseInt(st_time.nextToken());
                        int min = Integer.parseInt(st_time.nextToken());

                        team_1_hour += 48 - (hour-cur_hour);
                        team_1_min += (min-cur_min);

                        cur_hour = hour;
                        cur_min = min;
                    }

                    if (temp==2){
                        StringTokenizer st_time = new StringTokenizer(time,":");
                        int hour = Integer.parseInt(st_time.nextToken());
                        int min = Integer.parseInt(st_time.nextToken());

                        team_2_hour += 48 - (hour-cur_hour);
                        team_2_min += (min-cur_min);

                        cur_hour = hour;
                        cur_min = min;
                    }
                }

                // 그게 1팀이라면
                if (temp==1) {
                    // 시간과 분을 쪼갠다
                    StringTokenizer st_time = new StringTokenizer(time,":");
                    int hour = Integer.parseInt(st_time.nextToken());
                    int min = Integer.parseInt(st_time.nextToken());

                    team_1_hour += (hour-cur_hour);
                    team_1_min += (min-cur_min);

                    cur_hour = hour;
                    cur_min = min;
                }else{
                    StringTokenizer st_time = new StringTokenizer(time,":");
                    int hour = Integer.parseInt(st_time.nextToken());
                    int min = Integer.parseInt(st_time.nextToken());

                    team_2_hour += (hour-cur_hour);
                    team_2_min += (min-cur_min);

                    cur_hour = hour;
                    cur_min = min;
                }
            }

        }

        System.out.println(team_1_hour+":"+team_1_min);
        System.out.println(team_2_hour+":"+team_2_min);

    }
}
