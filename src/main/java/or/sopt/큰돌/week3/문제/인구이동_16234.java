package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;


// 너무 어렵다 걍 틀림
public class 인구이동_16234 {

    static class Pos{
        int y;
        int x;

        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pos> queue = new LinkedList<>();
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int n;
    static int l;
    static int r;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 호출
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){

                // 방문처리가 안되어있다면 bfs
                if (!visited[i][j]) bfs(i,j);

            }
        }
    }

    static void bfs(int y, int x){

        // queue에 넣고 방문처리
        queue.offer(new Pos(y,x));
        visited[y][x] = true;

        // 큐가 빌때까지 while
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int a = pos.y;
            int b = pos.x;

            for (int i=0; i<4; i++){
                // l&r 조건에 맞는지 검사하는 플래그
                boolean flag = false;
                int next_y = a+dy[i];
                int next_x = b+dx[i];
                Pos nextPos = new Pos(next_y,next_x);
                flag = check(pos, nextPos);

                // 만약 방문처리가 안되어 있고 l&r의 값과 맞는다면 큐에 넣기
                if (0<next_y || n-1>next_y || 0<next_x || n-1>next_x) continue;
                if (!visited[next_y][next_x] && flag){
                    queue.offer(nextPos);
                }
            }

        }

    }


    // 조건에 일치하는지 보는 메서드
    static boolean check(Pos pos, Pos nextPos){
        int temp = arr[pos.y][pos.x] - arr[nextPos.y][nextPos.x];

        if (temp>l && temp<r){
            return true;
        }else{
            return false;
        }
    }
}
