package or.sopt.큰돌.week3.문제;

import java.io.*;
import java.util.*;

public class 지훈_4179 {

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static char[][] arr;
    static ArrayList<Pos> fire = new ArrayList<>();
    static Pos person;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if (c == 'F') fire.add(new Pos(i, j));
                if (c == 'J') person = new Pos(i, j);
                arr[i][j] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        int result = fun(0);
        System.out.print(result);

    }

    static int fun(int cnt){

        // 불을 모두 이동시킴
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                char cur = arr[i][j];
                if (cur == 'F'){
                    for (int k=0; k<4; k++){
                        int next_y = i + dy[k];
                        int next_x = j + dx[k];

                        if (next_y<0 || next_y>=n || next_x<0 || next_x>=m) continue;
                        // 벽이면 불이 못붙음
                        if (arr[next_y][next_x] == '#') continue;

                        arr[next_y][next_x] = 'F';
                    }
                }
            }
        }

        // 이제 사람을 이동시킴
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                char cur = arr[i][j];

                if (cur == 'J'){
                    for (int k=0; k<4; k++){
                        int next_y = i + dy[k];
                        int next_x = j + dx[k];

                        if (next_y<0 || next_y>=n || next_x<0 || next_x>=m) continue;
                        // 벽이거나 불이면 못움직임
                        if (arr[next_y][next_x] == '#' || arr[next_y][next_x] == 'F') continue;

                        // 벽도 아니고, 불도 아닌 움직일 수 있는 곳이라면 재귀 시작
                        arr[next_y][next_x] = 'J';
                        fun(cnt++);

                        // 원복 로직
                        arr[next_y][next_x] = '.';
                    }

            }
        }

    }

        return cnt;
    }
}
