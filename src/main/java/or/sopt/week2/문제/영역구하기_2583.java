package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

// 오 뭐야 맞춤
public class 영역구하기_2583 {

    static int[][] arr;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visited;
    static int m_y;
    static int n_x;

    // 직사각형의 개수
    static int cnt = 0;
    // 직사각형 넓이
    static int a = 0;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m_y = Integer.parseInt(st.nextToken());
        n_x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[m_y][n_x];
        visited = new boolean[m_y][n_x];

        for (int i=0; i<k; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int start_x = Integer.parseInt(st2.nextToken());
            int start_y = Integer.parseInt(st2.nextToken());
            int end_x = Integer.parseInt(st2.nextToken());
            int end_y = Integer.parseInt(st2.nextToken());


            for (int j=start_y; j<end_y; j++){
                for (int h=start_x; h<end_x; h++){
                    arr[j][h]=1;
                }
            }
        }


        for (int i=0; i<m_y; i++){
            for (int j=0; j<n_x; j++){
                if (!visited[i][j] && arr[i][j]==0){

                    // 직사각형의 개수를 UP한다
                    cnt++;
                    dfs(i,j);
                    result.add(a);
                    a=0;
                }
            }
        }

        System.out.println(cnt);
        result.sort(Comparator.naturalOrder());
        for (Integer integer : result) {
            System.out.print(integer+" ");
        }

    }

    static void dfs(int y, int x){
        visited[y][x] = true;
        a++;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (0>next_y || 0>next_x || m_y<=next_y || n_x<=next_x) continue;
            if (!visited[next_y][next_x] && arr[next_y][next_x]==0){
                dfs(next_y,next_x);
            }
        }
    }
}
