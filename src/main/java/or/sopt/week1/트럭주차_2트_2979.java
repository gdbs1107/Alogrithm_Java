package or.sopt.week1;

import java.util.*;
import java.io.*;


public class 트럭주차_2트_2979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fee = 0;

        int A_budget = Integer.parseInt(st.nextToken());
        int B_budget = Integer.parseInt(st.nextToken());
        int C_budget = Integer.parseInt(st.nextToken());


        // 트럭과 상주시간을 기록 할 수 있는 배열을 만든다
        int[][] truck = new int[3][2];
        int[] time = new int[101];

        // 상주 시간을 받는다
        for(int i=0; i<3; i++){

            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            truck[i][0] = startTime;
            truck[i][1] = endTime;

            // 파킹타임을 계산해서 그 구간만큼 time 배열을 채운다
            // 그렇게 하면 parkingTime이 startTime보다 작은경우 아예 계산이 불가능 -> 그냥 endTime으로 잡아도 됨
            for (int j = startTime; j < endTime; j++){
                time[j]++;
            }
        }

        for (int i = 0; i<time.length; i++){

            if (time[i] == 0) {
                continue;
            }else if(time[i] == 1){
                fee += A_budget * time[i];
            }else if(time[i] == 2){
                fee += B_budget * time[i];
            } else if(time[i] == 3){
                fee += C_budget * time[i];
            }

        }

        System.out.print(fee);

    }
}
