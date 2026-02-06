package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 안전영역_2468 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int max = 0;
    static int cnt = 0;
    static int[] result;
    static int result_cnt = 0;
    static int n=0;

    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());

                // 입력값 중 가장 큰 값을 max에 저장한다 -> 이게 최대 수심이 되는거임
                max = Math.max(num,max);
                arr[i][j] = num;
            }
        }

        // 수심별로의 결과를 저장할 배열
        result = new int[max];

        // 물의 수심을 갈수록 높여서 조건을 올린다
        for (int i=0; i<max; i++) {

            // 방문처리를 수심이 바뀔때마다 새롭게 초기화해야지
            visited = new boolean[n][n];

            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){

                    if (!visited[j][k] && arr[j][k]>i){
                        dfs(j,k,i);
                        cnt++;
                    }
                }
            }

            result[i] = cnt;
            cnt = 0;
        }

        for (int i=0; i<max; i++){
            result_cnt = Math.max(result_cnt,result[i]);
        }

        System.out.print(result_cnt);
    }


    static void dfs(int y, int x, int height){
        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (next_y<0 || next_x<0 || next_y>=n || next_x>=n) continue;
            if (!visited[next_y][next_x] && arr[next_y][next_x]>height){
                dfs(next_y,next_x,height);
            }
        }
    }
}
