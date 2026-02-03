package or.sopt.큰돌.week3.개념;

import java.util.*;
import java.io.*;

/**
10 20 21
70 90 12
80 110 120
 * */
public class 홍철이 {

    static int[][] arr = new int[3][3];
    static boolean[][] visited = new boolean[3][3];
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            }
        }

        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int y, int x){
        result.add(arr[y][x]);
        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (next_y < 0 || next_x < 0 || next_y >= 3 || next_x >= 3) continue;

            if (!visited[next_y][next_x]){
                dfs(next_y, next_x);
            }
        }

        visited[y][x] = false;
    }
}
