package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 트럭주차_2979 {

    /**
     * 이 병2신아 배열을 생성할때 파라미터는 배열의 원소갯수다
     * 인덱스가 아니라
     * */
    public static void main(String[] args) throws IOException {

        // 주차한 요금을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parkingTimeList = new int[3];

        int A_Budget = Integer.parseInt(st.nextToken());
        int B_Budget = Integer.parseInt(st.nextToken());
        int C_Budget = Integer.parseInt(st.nextToken());

        // 각 자동차 별로 주차되는 시간을 기록한다
        for (int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            int parkingTime = endTime - startTime;
            parkingTimeList[i] = parkingTime;
        }

        System.out.println((A_Budget*parkingTimeList[0])+(B_Budget*parkingTimeList[1])+(C_Budget*parkingTimeList[2]));
    }


    /**
     * 처음 생각할때: A,B,C 별로 각 차가 지불해야하는 금액이 같아야하는 줄 알았음 근데 그게 아니네?
     *
     * 결국 풀어야하는 방향은
     * A,B,C가 주차되어있는 시간을 설정하고 그 시간 중 겹치는 시간들에 따른 시간을 계산해야한다는거네.
     * */

}
