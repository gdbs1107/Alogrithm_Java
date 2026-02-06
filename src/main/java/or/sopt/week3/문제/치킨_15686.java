package or.sopt.week3.문제;

import java.util.*;
import java.io.*;

public class 치킨_15686 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int n;
    static int m;
    static Queue<Pos> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 결과값이 담길 result
        ArrayList<Integer> result = new ArrayList<>();
        int a = 0;
        arr = new int[n][n];

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] == 1){
                    visited = new boolean[n][n];
                    queue.offer(new Pos(i,j));
                    // bfs의 결과로 나온 값을 계속 결과값에 더해간다
                    int temp = bfs();

                    result.add(temp);
                }
            }
        }

        Collections.sort(result);

        for (int i=0; i<m; i++){
            a += result.get(i);
        }

        System.out.print(a);
    }

    // bfs 함수 내에서 가장 작은 값을 턴마다 갱신한다
    static int bfs(){

        // 최소값은 0으로 초기화하면 안되지;
        int local_min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            visited[pos.y][pos.x] = true;

            for (int i=0; i<4; i++){
                int next_y = pos.y + dy[i];
                int next_x = pos.x + dx[i];

                if (next_y<0 || next_y>=n || next_x<0 || next_x >=n) continue;
                // bfs는 무조건 하는데, 이 중에서 2가 걸렸을때만 계산을 한다
                if (!visited[next_y][next_x]){
                    Pos next_pos = new Pos(next_y,next_x);
                    queue.offer(next_pos);

                    // 둘 사이의 거리 계산
                    if (arr[next_y][next_x] == 2){
                        int res = dist(pos, next_pos);

                        local_min = Math.min(local_min,res);
                    }
                }
            }
        }

        return local_min;
    }

    static int dist(Pos pos, Pos next_pos){
        int y = Math.abs(next_pos.y - pos.y);
        int x = Math.abs(next_pos.x - pos.x);

        return y+x;
    }



    static class Pos{
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
