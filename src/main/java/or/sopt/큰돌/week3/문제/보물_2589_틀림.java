package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

public class 보물_2589_틀림 {

    static String[][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visited;
    static int n;
    static int m;
    static int cnt;
    static int max = 0;

    /**
     * 보물은 서로간에 거리가 가장 먼 두 블록에 존재한다
     *
     * 그러면 0,0부터 시작해서 육지라면 dfs를 시작하고
     * 이동하면서 계속 cnt를 ++한다
     *
     * 그리고 그 결과값을 max 함수에 넣어서 최댓값을 계속 갱신하고
     * 그걸 출력한다면?
     *
     * 접근은 맞았지만, dfs가 아니다. 최단 경로는 BFS로 접근해야함
     * dfs는 깊이우선 탐색이기 때문에 경로에 따라서 최댓값이 달라질 수 있음
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        int n = Integer.parseInt(st.nextToken());
        // 가로
        int m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];

        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<m; j++){
                arr[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j].equals("L")){
                    // cnt 초기화
                    cnt = 0;
                    visited = new boolean[n][m];
                    dfs(i,j);
                    max = Math.max(max,cnt);
                }
            }
        }

        System.out.println(max);

    }

    // 육지로만 이동 가능 & 방문 안했어야함 & 범위 넘어가면 안됨
    static void dfs(int y, int x){
        visited[y][x] = true;
        cnt++;

        for (int i=0; i<4; i++){

            int next_y = y+dy[i];
            int next_x = x+dx[i];
            if (next_y<0 || next_x<0 || next_y >=n || next_x >=m) continue;
            if (arr[next_y][next_x].equals("L") && !visited[next_y][next_x]) {
                dfs(next_y, next_x);
            }

        }
    }

}
