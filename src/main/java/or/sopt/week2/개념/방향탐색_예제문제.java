package or.sopt.week2.개념;

import java.util.*;
import java.io.*;

public class 방향탐색_예제문제 {

    /**
1 0 1
1 0 1
0 1 1
     *
     * */

    // 4방향
    static int[] dy = {-1,0,1,0};
    static int[] dx = {-0,1,0,-1};
    static int[][] arr = new int[3][3];
    static boolean[][] visited = new boolean[3][3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<3; i++){

            System.out.println(i);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        go(0,0);

    }


    public static void go(int x, int y){

        visited[x][y] = true;

        for (int i=0; i<4; i++){

            int nx = x + dy[i];
            int ny = y + dx[i];

            // 오버플로우 조건
            if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
            // 방문했다면 skip
            if (visited[nx][ny]) continue;
            // 갈 수 없는 곳이면 skip
            if (arr[nx][ny] == 0) continue;

            System.out.println(nx+" : "+ny);
            go(nx,ny);
        }
    }
}
