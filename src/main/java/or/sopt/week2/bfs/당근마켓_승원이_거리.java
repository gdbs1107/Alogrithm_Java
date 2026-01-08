package or.sopt.week2.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 당근마켓_승원이_거리 {

    /**
     5 5
     0 0
     4 4
     1 0 1 0 1
     1 1 1 0 1
     0 0 1 1 1
     0 0 1 1 1
     0 0 1 1 1
     * */
    static int[][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] visited;
    static Queue<Pos> queue = new LinkedList<>();
    static int n_y;
    static int m_x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세로 n, 가로 m
        StringTokenizer st = new StringTokenizer(br.readLine());
        n_y = Integer.parseInt(st.nextToken());
        m_x = Integer.parseInt(st.nextToken());
        arr = new int[n_y][m_x];
        visited = new int[n_y][m_x];

        // 시작 위치
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int start_y = Integer.parseInt(st1.nextToken());
        int start_x = Integer.parseInt(st1.nextToken());

        // 끝 위치
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int end_y = Integer.parseInt(st2.nextToken());
        int end_x = Integer.parseInt(st2.nextToken());

        // map 초기화
        for (int i=0; i<n_y; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            for (int j=0; j<m_x; j++){
                arr[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        // start 방문처리
        visited[start_y][start_x] = 1;
        // start부터 bfs 시작 -> 얘는 재귀가 아니라서 반드시 시작점을 방문처리하고 가야한다
        bfs(start_y, start_x);

        System.out.println("정답 = " + visited[end_y][end_x]);
    }


    static void bfs(int y, int x){

        // 시작점을 큐에 넣는다
        queue.offer(new Pos(y,x));

        while (!queue.isEmpty()){

            Pos now = queue.poll();
            int now_y = now.y();
            int now_x = now.x();

            System.out.println("현재 y: "+now_y);
            System.out.println("현재 x: "+now_x);

            // 시작점부터 네방향을 탐색한다
            for (int i=0; i<4; i++){
                int next_y = now_y+dy[i];
                int next_x = now_x+dx[i];

                if (0>next_y || 0>next_x || n_y<=next_y || m_x<=next_x){
                    continue;
                }

                // 육지이고 아직 방문한적 없으면 다 큐에 담는다
                if (arr[next_y][next_x]==1 && visited[next_y][next_x]==0){
                    queue.offer(new Pos(next_y, next_x));

                    // 그 전까지의 가중치를 여기다가 더해주는거니까 같은 가중치에 한해서 거리를 측정 할 수 있게 되는거지
                    visited[next_y][next_x] = visited[now_y][now_x] +1;
                }
            }

        }

    }


    static record Pos(int y, int x){}
}
