package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1931 {
    /**
     * 회의의 시작시간과 끝시간이 정해져있고
     * 이들이 겹치지 않게 하면서 회의실을 사용 할 수 있게하는 최대 팀 개수를 구하라
     *
     * 최대한 많은 회의ㅡㄹㄹ 진행하려면 회ㅡ이시간이 짧아야하나?
     * 1. 회의 시작시간 순으로 쭉 정렬해두고
     * 1-1. 같은 시간이 있다면 회의시간이 더 짧은 시간으로 선택함
     * 2. 그리고 count를 올리고
     * 3. 그 다음으로 최신의 회의를 진행하고 count 올리고
     *
     * 뭐 이런식으로 count 계속 쌓아가면 되려나?
     *
     * 그럼 필요한게
     * 1. Map<Integer,Integer> times
     * 2. int count
     *
     * 그럼 저 반복문은 어떻게 돌아야할까
     * Map을 기준으로 반복문을 돌면서 아 아니지 n을 기준으로 반복문을 돌면되지
     *
     *
     * ---------
     *
     * 저렇게 하니까 틀렸음.
     * 왜냐면 저거보다 좋은 경우의 수가 존재해버렸음. 0~6을 포함하면 답이 안나오는거임
     * 사실 그리디를 몰랐다면 그냥 백트래킹을 해버렸을거같은데
     *
     * 아 어떻게 풀어야하띾
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 시작시간, 끝시간
        int[][] times = new int[n][2];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        // 이제 시작시간을 기준으로 정렬한다
        // 2트: 시작시간 순 정렬이 아니라 끝나는 시간을 기준으로 정렬한다
        Arrays.sort(times, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;

        // 시작시간을 설정하기: 0으로 설정한다고 치고
        int start = 0;
        for (int i=0; i<n; i++){

            // 현재 가능한 시작시간이 다음 회의 시작시간보다 앞이라면 -> continue
            if (start>times[i][0]) continue;

            // times[i][0]를 꺼낸다.
            count++;
            // times[i][1] 이 새로운 시작점이 된다.
            start = times[i][1];
        }

        System.out.print(count);
    }
}
