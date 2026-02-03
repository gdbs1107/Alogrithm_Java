package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

public class 보물_2589 {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<m; j++) {

                // W: 87, L: 76 임을 이용해서 맵을 int로 만들어둠 -> 육지가 1
                int num = line[j].charAt(0)-0;
                if(num == 87)map[i][j] = -1;
                else map[i][j] = 1;
            }
        }

        int max = -1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] ==1) {

                    // 육지라면 bfs가 돌아감
                    visited = new boolean[n][m];
                    int res =  bfs(j,i);

                    // 제일 높은 거리를 계산
                    if(res > max) {
                        max =res;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        int maxMove =-1;
        visited[y][x] =true;

        // x,y와 Distance를 같이 넣음
        q.add(new int[] {x,y,0});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            int move = pos[2];

            if(move > maxMove) {
                maxMove = move;
            }

            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx <0 || nx >m-1 || ny<0 || ny >n-1) continue;

                if(!visited[ny][nx] && map[ny][nx]==1) {
                    visited[ny][nx] =true;

                    // 다음 육지를 발견하면 한 칸 이동
                    q.add(new int[]{nx,ny, move+1});
                }
            }
        }

        // 모든 로직이 끝나면 i,j에서의 최종적인 maxMove를 반환함
        return maxMove;

    }
}
