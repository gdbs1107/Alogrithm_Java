package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * depth를 구하는 문제인데, 토마토가 사방향에 있는 토마토를 1로 만든다
 * 그러면 dfs인 것 같긴한데
 *
 * 1인 지점부터 시작해서 어느곳도 갈 수 없게 될 때까지의 depth를 구하고
 * 근데 최솟값을 구해야하는거니까 머리가 좀 아프긴하네
 * depth를 파라미터로 갖고가서 결국 어디도 갈 수 없게 되었을 때를 가정해야하는건데...그러면 각자의 map을 지녀야하니까 그건 아니고
 *
 * 일단 일반적인 bfs아님 근데? 어찌보면 최단거리 문제긴 함.
 * 가는 블록이 1이라면 그냥 감
 * 0이면 1로 만들고 감
 * -1이면 안감
 *
 * 아니지 그냥 depth만 가져가면
 * */
public class b7576 {

    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int n;
    static int m;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){

                if (map[i][j]==1 && !visited[i][j]){
                    for (int i=0; i<4; i++){
                        y = i+dy[i];
                        x = j+dx[i];

                        if (map[y][x]==0) {
                            map[y][x]=1;
                            visited[y][x] = true;
                        }
                    }
                }

            }
        }
    }

    static void bfs(){

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[0];

            // 현재 칸이 1이면 주변에 있는 칸들을 1로 만든다
            // 그리고 방문처리한다
            if (map[y][x]==1){
                for (int i=0; i<4; i++){
                    int next_y = y+dy[i];
                    int next_x = x+dx[i];

                    if (next_y<0 || next_x<0 || next_y>=n; next_x>=m) continue;
                    if (!visited[next_y][next_x]){
                        visited[next_y][next_x] = true;
                        if (map[next_y][next_x]==0) map[next_y][next_x] = 1;
                    }

                }
            }


        }
    }

}
