package or.sopt.기초;

/**
 *
 * 3
 *      * 1 3
 *      * 2 4
 *      * 3 5
 * bfs는 실패함 그럼 어떻게 하지
 *
 * 그럼 우선 시작시간으로 정렬하고, 본인 끝나는 시간이랑 겹치거나 보다 늦게 시작하는 애들은 한 강의실로 잡음
 * 그 사이에 겹치는 애가 있으면 이건 어떡하지? 아 방문처리를 할까?
 *
 * for문으로 모든 시작시간을 다 돌고
 * times[i][0] = start
 * int min을 잡고 이걸 계속 times[i][1] 로 초기화해주는거지
 *
 * 근데 이때 min보다 작은 times[i]가 들어온다면 skip
 *
 * */

import java.util.*;
import java.io.*;

public class b11000_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i][0] = start;
            times[i][1] = end;
        }

        // 시작 시간을 기준으로 배열을 정렬한다
        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int result = 0;
        for (int i=0; i<n; i++){
            // 만약 해당 포인트를 방문한 적이 있다면 그냥 skip
            if (visited[i]) continue;

            // 방문한적이 없다면 로직 실행
            result++;
            int flag = -1;
            for (int j=i; j<n; j++){
                int start = times[j][0];
                int end = times[j][1];

                // 만약 start가 flag보다 작으면 continue
                if (start<flag) continue;

                // 그게 아니라면 flag를 새로운 times[i][1]로 초기화
                flag = end;
                visited[j] = true;
            }
        }

        System.out.print(result);
    }
}
