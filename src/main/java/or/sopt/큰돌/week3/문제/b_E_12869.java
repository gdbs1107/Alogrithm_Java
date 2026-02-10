package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

public class b_E_12869{

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
static int level = 0;

public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] scv = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++){
        scv[i] = Integer.parseInt(st.nextToken());
    }

    queue.offer(new Pos(scv[0],scv[1],scv[2]));
    bfs();

    System.out.print(level);
}



static void bfs(){

    boolean flag = false;

    while(true){

        Pos p = queue.poll();
        int na = p.a;
        int nb = p.b;
        int nc = p.c;

        for (int i=0; i<6; i++){

            na = na-d[i][0];
            nb = nb-d[i][1];
            nc = nc-d[i][2];
            if (na<=0 && nb<=0 && nc<=0) {
                flag = true;
                break;
            }else{
                queue.offer(new Pos(na,nb,nc));
            }
        }

        if (flag) break;

        level++;
    }
}
}
