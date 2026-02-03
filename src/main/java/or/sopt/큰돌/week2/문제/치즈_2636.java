package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

/**
 * 1. 컴포넌트 찾기를 활용해서 '구멍'을 찾고 방문처리
 * 2. 방문처리가 된 곳을 제외하고, 주변에 0이 존재하는 1블록을 0으로 전환함 -> 그리고 cnt++하면 되는데
 *
 * 문제는 1번 컴포넌트 찾기에서 구멍이 아닌 다른 주변도 다 탐색 될 수 있다는게 문제
 * ------------------------------------------------------------------------
 *
 * 구멍을 찾는게 아니라 그냥 1이 나오면 더 탐색을 하지 않으면 되는 것이다.
 * 어차피 구멍은 생각할 필요가 없어. 구멍이 부식되지 않는다는 조건은 출제자의 배려였다.
 * */
public class 치즈_2636 {

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] visited;
    static int[][] arr;
    static List<Pos> melt;
    static int y;
    static int x;
    static int cnt = 0;
    static int size = 0;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];

        // 이중 배열을 완성하고
        for (int i=0; i<y; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=0; j<x; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // while 반복을 해야하는데 어떻게 종료조건을 잡아야할까
        while(true){
            visited = new int[y][x];
            melt = new ArrayList<>();
            boolean flag = false;

            for (int i=0; i<y; i++){
                for (int j=0; j<x; j++){
                    if (arr[i][j] == 1){
                        flag = true;
                    }
                }
            }

            if (flag){
                cnt++;
                dfs(0,0);
            }else{
                break;
            }
        }

        System.out.println(cnt);
        System.out.println(size);

    }

    static void dfs(int start_y, int start_x){
        // 방문처리하고
        visited[start_y][start_x] = 1;

        for (int i=0; i<4; i++){
            int next_y = start_y + dy[i];
            int next_x = start_x + dx[i];

            // 다음 위치가 경계선을 넘지 않는다면
            if (next_y<0 || next_x<0 || next_x>=x || next_y>=y){
                continue;
            }

            // 만약 다음 위치가 1이라면 && 방문처리가 되지 않았다면 -> Map에 넣고, 방문처리하고 continue;
            if (arr[next_y][next_x]==1 && visited[next_y][next_x]==0){
                melt.add(new Pos(next_y, next_x));
                visited[next_y][next_x] = 1;
            }

            // 만약 다음 위치가 방문처리가 안되어있는 0이라면 -> dfs()
            if (arr[next_y][next_x]==0 && visited[next_y][next_x]==0){
                dfs(next_y, next_x);
            }
        }

        // melt 안에있는 친구들을 모두 0으로 만들어야함
        for (int i=0; i<melt.size(); i++){
            Pos pos = melt.get(i);

            int melt_y = pos.y;
            int melt_x = pos.x;

            arr[melt_y][melt_x] = 0;
        }

        size = melt.size();
    }

    static class Pos{
        int y;
        int x;

        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}
