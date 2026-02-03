package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

public class 배추_1012 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int cnt = 0;
    static int n_y;
    static int m_x;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            m_x = Integer.parseInt(st.nextToken());
            n_y = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            arr = new int[n_y+1][m_x+1];
            visited = new boolean[n_y][m_x];

            for (int j=0; j<pos; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr[y][x]= 1;
            }


            for (int k=0; k<n_y+1; k++){
                for (int h=0; h<m_x+1; h++){
                    if (arr[k][h]==1 && !visited[k][h]){
                        cnt++;
                        dfs(k,h);
                    }
                }
            }

            System.out.println(cnt);

            cnt=0;

        }


    }


    static void dfs(int y, int x){

        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (0>next_y || 0>next_x || n_y<=next_y || m_x<=next_x) continue;

            if (arr[next_y][next_x]==1 && !visited[next_y][next_x]){
                dfs(next_y,next_x);
            }
        }
    }

}
