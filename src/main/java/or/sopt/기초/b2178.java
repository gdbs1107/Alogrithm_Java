package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 *
 * */
public class b2178 {

    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n;
    static int m;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.print(map[n - 1][m - 1]);
    }

    static void bfs() {
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_y = cur[0];
            int cur_x = cur[1];

            for (int i = 0; i < 4; i++) {
                int next_y = cur_y + dy[i];
                int next_x = cur_x + dx[i];

                if (next_y >= 0 && next_x >= 0 && next_y < n && next_x < m) {
                    if (!visited[next_y][next_x] && map[next_y][next_x] == 1) {
                        queue.offer(new int[]{next_y, next_x});
                        visited[next_y][next_x] = true;
                        map[next_y][next_x] = map[cur_y][cur_x] + 1;
                    }
                }
            }
        }
    }
}