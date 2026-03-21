package or.sopt.기초;

/**
 * 위로 가는 경우
 * dy +1
 * dx 0
 *
 * 한 칸 더 가서 좌/우로 가는경우
 * dy +1 +1
 * dx +0 -1/+1
 *
 * -> {+2,-1}, {+2,+1}
 * -> {-2,-1}, {-2,+1}
 * -----
 *
 * 아래로 가는 경우
 *
 * dy -1
 * dx 0
 *
 * 한 칸 더 가서 좌/우로 가는경우
 * dy -1 -1
 * dx +0 -1/+1
 *
 * 옆으로 가는 경우
 * dy +0 -1/+1
 * dx +1 +1
 * -> {-1,2}, {+1,2}
 * -> {-1,-2}, {+1,-2}
 * 그냥 무조건 전진시켜서 거기서 한 번더 움직이게 하는게 베스트인데 그러면 계속 같은자리를 돌 수 없지 왜냐면 방문처리하니까
 * 그럼 경우의 수가
 *
 * -> {+2,-1}, {+2,+1}
 * -> {-2,-1}, {-2,+1}
 * -> {-1,2}, {+1,2}
 * -> {-1,-2}, {+1,-2}
 *
 * 이걸 기반으로 dy,dx를 구해서 진행하면 되겠다
 * */


import java.util.*;
import java.io.*;

public class b7562 {

    static int[] dy = {2,2,-2,-2,-1,+1,-1,+1};
    static int[] dx = {-1,+1,-1,+1,2,2,-2,-2};
    static int[][] map;
    static boolean[][] visited;

    static int[] target = new int[2];
    static Queue<int[]> queue;
    static int n;

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i=0; i<tc; i++){
            queue = new LinkedList<>();
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            queue.offer(new int[]{y,x});
            visited[y][x] = true;
            bfs();
            System.out.println(map[target[0]][target[1]]);
        }
    }

    static void bfs(){

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i=0; i<8; i++){
                int next_y = y+dy[i];
                int next_x = x+dx[i];

                if (next_y<n && next_x<n && next_y>=0 && next_x>=0){
                    if (!visited[next_y][next_x]){
                        queue.offer(new int[]{next_y,next_x});
                        visited[next_y][next_x] = true;
                        map[next_y][next_x] = map[y][x]+1;

                        if (next_y==target[0] && next_x==target[1]){
                            return;
                        }
                    }
                }
            }
        }

    }
}
