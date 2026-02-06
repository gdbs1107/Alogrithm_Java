package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 미로_2178 {

    static int[][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] visited;
    static Queue<Pos> queue;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        for (int i=1; i<n+1; i++){
            String input = br.readLine();

            // 아스키 코드 상의 0은 48이다. 그러니까 0을 빼서 0이면 0을 넣고, 1이면 1이 들어가도록 하는거임
            for (int j=1; j<m+1; j++){
                arr[i][j] = input.charAt(j-1) - '0';
            }
        }

        System.out.println("표는 잘 나옴");

        queue.offer(new Pos(1,1));
        visited[1][1] = 1;

        while(!queue.isEmpty()){

            Pos now = queue.poll();
            int now_y = now.y;
            int now_x = now.x;

            System.out.println(now_y + " " + now_x);

            for (int i=0; i<4; i++){
                int next_y = now_y + dy[i];
                int next_x = now_x + dx[i];

                if (0>next_y || 0>next_x || n+1<=next_y || m+1<=next_x) continue;

                if (arr[next_y][next_x]==1 && visited[next_y][next_x]==0){
                    queue.offer(new Pos(next_y, next_x));
                    visited[next_y][next_x] = visited[now_y][now_x] +1;
                }
            }
        }

        System.out.print(visited[n][m]);


    }

    /*// 자바 11에선 레코드 없네 ㅅㅂ
    static record Pos(int y, int x){}*/

    static class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
