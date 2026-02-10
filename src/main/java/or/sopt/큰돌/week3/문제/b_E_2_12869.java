package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

public class b_E_2_12869 {

    static class Pos{
        int a;
        int b;
        int c;

        Pos(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int[][] d = {
            {9,3,1},
            {9,1,3},
            {1,3,9},
            {1,9,3},
            {3,1,9},
            {3,9,1}
    };

    static Queue<Pos> queue = new LinkedList<>();
    static int[][][] dist = new int[61][61][61];
    static boolean[][][] visited = new boolean[61][61][61];

    static int level = 0;

    // 범위를 체크하는 메서드
    static int clamp(int x){
        if (x < 0) return 0;
        return x;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scv = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        int a = scv[0];
        int b = (n >= 2) ? scv[1] : 0;
        int c = (n >= 3) ? scv[2] : 0;

        visited[a][b][c] = true;
        dist[a][b][c] = 0;
        queue.offer(new Pos(a,b,c));

        bfs();

        System.out.print(level);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Pos p = queue.poll();

            // clamp 함수에서 0이하면 다 0으로 만들어버리니까 0으로 필터링함
            if (p.a == 0 && p.b == 0 && p.c == 0){
                level = dist[0][0][0];
                return;
            }

            /**
             * 왜 이걸 p.a에 바로 할당하면 안될까?
             *
             * p.a에 바로 할당하면 다음번에 P.a다시 꺼낼때 또 그거 나오니까 멍-청아
             * */
            for (int i=0; i<6; i++){
                int na = clamp(p.a - d[i][0]);
                int nb = clamp(p.b - d[i][1]);
                int nc = clamp(p.c - d[i][2]);

                if (!visited[na][nb][nc]){
                    visited[na][nb][nc] = true;
                    dist[na][nb][nc] = dist[p.a][p.b][p.c] + 1;
                    queue.offer(new Pos(na, nb, nc));
                }
            }
        }
    }
}