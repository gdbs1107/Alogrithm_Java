package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 백준 1697번: 숨바꼭질
 * 문제: 수빈이가 동생을 찾을 수 있는 최소 시간 구하기
 * 방법: BFS를 사용하여 최단 시간 탐색
 * 시간 복잡도: O(N), N은 위치의 범위 (0 ~ 100,000)
 */
public class b1697 {

    static boolean[] visited;   // 각 위치의 방문 여부를 체크하는 배열
    static int N, K;            // N: 수빈이 위치, K: 동생 위치
    static int result = 0;      // 최소 시간을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        visited = new boolean[100001];

        bfs(N, K);

        System.out.println(result);
    }


    /**
     * BFS로 최단 시간을 찾는 메서드
     * @param start 시작 위치 (수빈이 위치)
     * @param target 목표 위치 (동생 위치)
     */
    private static void bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();   // BFS를 위한 큐 생성
        visited[start] = true;                     // 시작 위치 방문 처리
        queue.offer(new int[]{start, 0});          // 큐에 시작 위치와 시간(0) 삽입

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int time = curr[1];

            if (pos == target) {
                result = time;
                return;
            }

            int[] direction = {pos + 1, pos - 1, pos * 2};
            for (int d : direction) {
                if (d >= 0 && d < 100001 && !visited[d]) {
                    visited[d] = true;
                    queue.offer(new int[]{d, time + 1});
                }
            }
        }
    }
}