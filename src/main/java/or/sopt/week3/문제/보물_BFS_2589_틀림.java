package or.sopt.week3.문제;

import java.util.*;
import java.io.*;

public class 보물_BFS_2589_틀림 {

    static String[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static int cnt;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        int n = Integer.parseInt(st.nextToken());
        // 가로
        int m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(input.charAt(j));
            }
        }

        // 이제 BFS 시작해야함

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("L")) {
                    visited = new boolean[n][m];
                    cnt = 0;
                    Queue<Pos> queue = new LinkedList<>();
                    queue.offer(new Pos(i, j));

                    while (!queue.isEmpty()){
                        Pos pos = queue.poll();
                        int y = pos.y;
                        int x = pos.x;

                        for (int k=0; k<4; k++){
                            int next_y = y+dy[k];
                            int next_x = x+dx[k];

                            if (next_y<0 || next_x<0 || next_y >=n || next_x >=m) continue;
                            if (arr[next_y][next_x].equals("L") && !visited[next_y][next_x]){
                                queue.offer(new Pos(next_y,next_x));
                                visited[next_y][next_x] = true;
                                cnt++;
                            }
                        }
                    }
                }

                max = Math.max(max,cnt);
            }
        }


        System.out.print(max);
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}