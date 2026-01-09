package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

// 모르겠다 -> 아예 그래프 탐색이 아니라 트리 문제네
public class 쿼드트리_1992 {

    static int[][] arr;
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            String input = br.readLine();

            for (int j=0; j<n; j++){
                int temp = input.charAt(j) - '0';
                arr[i][j] = temp;
            }
        }

        /*dfs(0,0,n);*/
    }

    /*static void dfs(int y, int x, int n){

        // n을 2로 나눈 값이 현재의 n이고
        int now_n = n/2;

        // 1사분면
        for (int i=0; i<now_n; i++){
            for (int j=0; j<now_n; j++){

                visited[i][j] = true;
                int current = arr[i][j];

                // 네 방향으로 for문
                for (int k=0; k<4; k++){
                    int next_y = y+dy[i];
                    int next_x = x+dx[i];

                    // 제약조건 걸고
                    if (next_y<0 || next_x<0 || next_y>=now_n || next_x>=now_n) continue;
                    if (!visited[next_y][next_x] && arr[next_y][next_x] != current){
                        dfs(now_n/2,now_n/2, now_n);
                    }

                }

            }
        }

        // 2사분면
        for (int i=0; i<now_n; i++){
            for (int j=now_n; j<n; j++){

                visited[i][j] = true;
                int current = arr[i][j];

                // 네 방향으로 for문
                for (int k=0; k<4; k++){
                    int next_y = y+dy[i];
                    int next_x = x+dx[i];

                    // 제약조건 걸고
                    if (next_y<0 || next_x<0 || next_y>=now_n || next_x>=now_n) continue;
                    if (!visited[next_y][next_x] && arr[next_y][next_x] != current){
                        dfs((now_n+n)/2,now_n/2, now_n);
                    }
                }
        }

        // 3사분면
        for (int i=now_n; i<n; i++){
            for (int j=0; j<now_n; j++){

                visited[i][j] = true;
                int current = arr[i][j];

                // 네 방향으로 for문
                for (int k=0; k<4; k++){
                    int next_y = y+dy[i];
                    int next_x = x+dx[i];

                    // 제약조건 걸고
                    if (next_y<0 || next_x<0 || next_y>=now_n || next_x>=now_n) continue;
                    if (!visited[next_y][next_x] && arr[next_y][next_x] != current){
                        dfs(now_n/2,(now_n+n)/2, now_n);
                    }
                }
            }

            }
        }

        // 4사분면
        for (int i=now_n; i<n; i++){
            for (int j=now_n; j<n; j++){

                visited[i][j] = true;
                int current = arr[i][j];

                // 네 방향으로 for문
                for (int k=0; k<4; k++){
                    int next_y = y+dy[i];
                    int next_x = x+dx[i];

                    // 제약조건 걸고
                    if (next_y<0 || next_x<0 || next_y>=now_n || next_x>=now_n) continue;
                    if (!visited[next_y][next_x] && arr[next_y][next_x] != current){
                        dfs((now_n+n)/2,(now_n+n)/2, now_n);
                    }
                }

            }
        }

    }*/
}
