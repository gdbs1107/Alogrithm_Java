package or.sopt.큰돌.week3.문제;

import java.util.*;
import java.io.*;

// 아니 최단거리가 BFS인건 알고 있는데 어떻게 단일 좌표에서 BFS를 하냐는거지
public class b_H_13913{

    static int a;
    static int b;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean flag = false;
    static int min = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        dfs(0, a);
        findCnt(0,a);

        System.out.println(min);
        System.out.println(cnt);
    }

    // 최소값을 찾는 로직
    static void dfs(int depth, int a){

        // 최초 한 번만 리턴해서 최솟값을 받음
        if (a==b && !flag){
            flag = true;
            result.add(depth);
            min = depth;
        }

        if (flag) return;

        dfs(depth+1, a+1);
        dfs(depth+1, a-1);
        dfs(depth+1, a*2);
    }

    static void findCnt(int depth, int a){
        // 최초 한 번만 리턴해서 최솟값을 받음
        if (depth==min && a==b){
            cnt++;
            return;
        }

        if (depth>min) return;

        findCnt(depth+1, a+1);
        findCnt(depth+1, a-1);
        findCnt(depth+1, a*2);
    }
}