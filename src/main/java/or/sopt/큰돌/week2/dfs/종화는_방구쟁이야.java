package or.sopt.큰돌.week2.dfs;

import java.util.*;
import java.io.*;

public class 종화는_방구쟁이야 {

    /**
5 5
1 0 1 0 1
1 1 0 0 1
0 0 0 1 1
0 0 0 1 1
0 1 0 0 0
     * */

    /**
     * dx와 dy를 이용해서 움직인다
     *
     * dx와 dy의 범위는 0<=dy<=n 과 같고
     * dfs를 통해 다음으로 이동하기 위한 조건은 visited[y][x]==false &&
     * 아니지. 만약 육지여야만 이동할 수 있다면 바다일때 아예 다음으로 이동 자체가 안되잖아
     *
     * 아 아니지 종화 방귀는 모든 육지를 다 오염시킨다
     * 1. 1번열부터 육지인 곳을 찾는다
     * 2. 육지인 곳부터 4방향 dfs를 시작한다
     * 3. 이제 더이상 갈 곳이 없다면 종료 -> 그게 하나의 육지인 것이다
     * */

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n이 세로 -> y, m이 가로 -> x
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            StringTokenizer sts = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++){
                int nextToken = Integer.parseInt(sts.nextToken());

                if (nextToken==1){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }


        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){

                // 그곳이 육지이고, 방문한 적이 없다면 dfs를 시작한다
                if (arr[i][j]==1 && !visited[i][j]){
                    cnt++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(cnt);
    }

    // 네 방향을 탐색하면서 육지고 방문한 적이 없다면 -> dfs 재귀한다
    public static void dfs(int y,int x){

        visited[y][x]=true;
        for(int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            // x와 y가 범위 밖으로 나가지 않도록
            if (0>next_y || n<=next_y || 0>next_x || m<=next_x){
                continue;
            }

            // 이게 호출이 된다는 것은 그 자체로 "가능"을 의미한ㄷ -> 반대로 호출이 안되면 불가능인 것이니까 해당 좌표에서의 dfs 호출이 종료됐다면
            // 육지는 끝난거임
            if (arr[next_y][next_x]==1 && !visited[next_y][next_x]){
                dfs(next_y,next_x);
            }
        }
    }
}
