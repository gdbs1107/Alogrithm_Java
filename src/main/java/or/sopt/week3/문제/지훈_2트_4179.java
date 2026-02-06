package or.sopt.week3.문제;

import java.util.*;
import java.io.*;

public class 지훈_2트_4179 {

    static int r,c;
    static char[][] map;
    // 사람, 불 Queue를 동시에 정의한다
    static Queue<int[]> fireQ, personQ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        String line;
        fireQ = new LinkedList<>();
        personQ = new LinkedList<>();
        for(int i=0; i<r; i++) {
            line = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = line.charAt(j);

                // 사람과 불을 먼저 넣고 시작함
                if(map[i][j] == 'J') {
                    personQ.add(new int[] {j,i,0});
                }else if(map[i][j] == 'F') {
                    fireQ.add(new int[] {j,i});
                }
            }
        }

        int res = -1;
        out: while(true) {

            // 불을 꺼내서 이동시킨다
            int fSize = fireQ.size();
            for(int i=0; i<fSize; i++) {
                int[] p = fireQ.poll();
                fireMoving(p[0], p[1]);
            }

            // 사람도 꺼내서 이동시킨다
            int pSize = personQ.size();
            for(int i=0; i<pSize; i++) {
                int[] p = personQ.poll();
                res = escape(p[0], p[1], p[2]);
                if(res != -1) break out;
            }
            if(personQ.isEmpty()) break;
        }

        if(res == -1) {
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println(res);
        }

    }

    static int escape(int x, int y, int time) {

        // 네 방향으로 사람을 이동시킴
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 ||  nx>c-1 || ny>r-1) {
                // 탈출이 됐다면 시간+1과 함께 리턴
                return time+1;
            }

            // 그게 아니라면 Queue에 add하는데, 이때 시간과 함께 넣는다
            if(map[ny][nx] == '.') {
                map[ny][nx] = 'J';
                personQ.add(new int[] {nx, ny, time+1});
            }
        }

        // 아무것도 움직이지 못한다면 -1 -> 탈출 실패
        return -1;
    }

    static void fireMoving(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 불은 벽에 닿으면 안됨
            if(nx < 0 || ny < 0 || nx > c-1 || ny > r-1) continue;

            // 조건에 맞으면 불이 번짐
            if(map[ny][nx] == '.' || map[ny][nx] == 'J') {
                map[ny][nx] = 'F';
                fireQ.add(new int[] {nx, ny});
            }
        }
    }
}