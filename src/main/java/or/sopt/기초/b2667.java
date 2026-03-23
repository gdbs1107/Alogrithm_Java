package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 아주 일반적인 그 그룹 찾기 문제인데, 여기서 인원 수가 추가된거임
 * 1. 변의 ㄱ리이 n
 * 2. dx,dy
 * 3. 방문처리
 * 4. 맵
 * 5. 결과배열
 *
 * dfs로 모든 점을 다 탐색하는데,
 * dfs재귀 들어갈때마다 +1
 * */
public class b2667 {

    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    static int n;
    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();
    static int temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j] && map[i][j]==1){
                    temp = 0;
                    dfs(i,j);
                    result.add(temp);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int var:result){
            System.out.println(var);
        }

    }

    static void dfs(int y, int x){
        visited[y][x] = true;
        temp++;

        for (int i=0; i<4; i++){
            int next_y = y+dy[i];
            int next_x = x+dx[i];

            if (next_y<0 || next_x<0 || next_y>=n || next_x>=n) continue;
            if (!visited[next_y][next_x] && map[next_y][next_x]==1){
                dfs(next_y,next_x);
            }
        }
    }



}
