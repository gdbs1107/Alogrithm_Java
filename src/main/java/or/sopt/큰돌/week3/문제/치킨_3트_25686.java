package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

// 아 안되겠다 이거 나중에 다시 풀어라 무조건
public class 치킨_3트_25686 {

    static class Pos{
        int y;
        int x;


        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int m;
    static int[][] arr;
    static ArrayList<Pos> house = new ArrayList<>();
    static ArrayList<Pos> chicken = new ArrayList<>();
    static ArrayList<Pos> selected = new ArrayList<>();
    static boolean[] chickenVisited;
    static int result = Integer.MAX_VALUE;

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;

                if (temp == 1){
                    house.add(new Pos(i,j));
                }
                if (temp==2){
                    chicken.add(new Pos(i,j));
                }
            }
        }

        chickenVisited = new boolean[chicken.size()];
        back(0,0);

    }

    static void back(int start, int depth){

        if (depth==m){

            int localResult = 0;

            // 거리 계산 로직 시작
            for (Pos h : house){
                // 하우스를 하나 빼와서 치킨집들과의 거리를 계산한다
                // 하우스와 치킨집에서 가장 가까운 거리를 구한다
                for (Pos c : chicken){
                    int temp = Math.abs(c.y - h.y) + Math.abs(c.x - h.x);
                    localResult += temp;
                }

                result = Math.min(localResult,result);
            }
        }

        // 치킨집 세 개 찾기
        for (int i=0; i<chicken.size(); i++){
            if (!chickenVisited[i]){
                chickenVisited[i] = true;
                Pos pos = chicken.get(i);
                selected.add(pos);
                back(i++, depth++);

                return;
            }

            // 원복 로직
            selected.remove(chicken.size() -1);
            chickenVisited[i] = false;
        }
    }
}
