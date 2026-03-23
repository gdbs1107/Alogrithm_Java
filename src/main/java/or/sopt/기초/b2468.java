package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2468 {

    /**
     * 비의 depth가 높아질수록 안전구역의 개수를 정하고 거기서 max를 구하면 된다
     *
     * 1. map
     * 2. visited
     * 3. n
     * 4. 결과배열[n]
     * 5. dx,dy
     *
     * 잠깐 근데 이슈가 있음
     * 이렇게 하려면 map이랑 visited를 매번 비 값을 올릴때마다 초기화해주어야함
     * 그럼 visited야 뭐 매번 초기화해준다고 치고
     * map을 snap_map을 만들어서 매번 초기화 해줘야겠는데
     *
     * 아니지 map을 왜초기화해 멍청아
     * */

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] res;

    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    static int rain;
    static int temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int max = 0;
        StringTokenizer st;
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }

        res =  new int[max+1];
        for (int i=0; i<=max; i++){
            rain = i;
            temp = 0;
            visited = new boolean[n][n];

            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    if (!visited[j][k] && map[j][k]>rain){
                        temp++;
                        dfs(j,k);
                        res[i] = temp;
                    }

                }
            }
        }

        Arrays.sort(res);
        System.out.print(res[max]);
    }

    static void dfs(int y, int x){
        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (next_y<0 || next_x<0 || next_y>=n || next_x>=n) continue;
            if (!visited[next_y][next_x] && map[next_y][next_x]>rain){
                dfs(next_y,next_x);
            }
        }
    }

}
