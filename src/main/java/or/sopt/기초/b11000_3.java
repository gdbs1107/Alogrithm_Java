package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11000_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간 기준 정렬, 같으면 종료 시간 기준 정렬
        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];

            /**
             * pq.peek() <= start:
             * peek() 에는 가장 최근에 끝난 강의의 종료시간이 들어있음
             * 그러니ㄱ까 peek() <= start라는 말은 다음 강의를 현재 강의와 같은 강의실에서 할 수 있다는 말임
             *
             * 근데 왜 pq.poll()을 하는거지?
             * 이제 새로운 강의가 들어갈거니까 ㅇㅎㅇㅎ
             * */
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            // 현재 강의의 종료시간 삽입
            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}