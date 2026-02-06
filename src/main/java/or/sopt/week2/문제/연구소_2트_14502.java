package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 연구소_2트_14502 {

    static int[][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int safeCnt = 0;
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 입력받은대로 map을 생성한다.
        for (int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // map을 대상으로 벽을 설치한다
        dfs(0);

        System.out.print(safeCnt);
    }


    // map을 대상으로 벽을 설치한다
    static void dfs(int wall_cnt){

        // 만약 벽이 세개라면 바이러스 탐색 시작 -> 탐색이 종료되면 원복하고 리턴한다
        if (wall_cnt == 3){
            bfs();
            return;
        }

        // 벽세우기
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j]==0){
                arr[i][j] = 1;
                dfs(wall_cnt+1);
                arr[i][j] = 0;
            }
        }

    }
    }


    // 설치한대로 바이러스를 퍼뜨린다
    static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        int[][] copyMap = new int[n][m];

        // 바이러스를 퍼뜨려야하기 때문에 기존의 map을 복사한다
        for (int i=0; i<n; i++){
            copyMap[i] = arr[i].clone();
        }

        int y = 0;
        int x = 0;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j]==2) {
                    queue.offer(new Pos(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Pos p = queue.poll();

            for (int i=0; i<4; i++){
                int nextY = p.y + dy[i];
                int nextX = p.x + dx[i];

                if (nextY<0 || nextX<0 || nextY>=n || nextX>=m){
                    continue;
                }

                if (copyMap[nextY][nextX] == 0){
                    copyMap[nextY][nextX] = 2;
                    queue.offer(new Pos(nextY,nextX));
                }
            }
        }

        countSafe(copyMap);
    }


    // 바이러스가 퍼진 map에서의 안전영역을 Max로 갱신하고 벽을 원복한다
    static void countSafe(int[][] copyMap){

        int temp = 0;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){

                if (copyMap[i][j] == 0){
                    temp++;
                }
            }
        }

        safeCnt = Math.max(temp,safeCnt);
    }



    static class Pos{
        int y;
        int x;

        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
