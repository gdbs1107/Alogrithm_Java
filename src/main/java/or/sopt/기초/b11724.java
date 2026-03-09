package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11724 {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int res = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        for (int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i=1; i<=n; i++){
            if (!visited[i]) {
                res++;
                dfs(i);
            }
        }

        System.out.print(res);
    }

    static void dfs(int n){
        visited[n] = true;
        ArrayList<Integer> tar = adj.get(n);

        for (Integer integer : tar) {
            if (!visited[integer]) dfs(integer);
        }
        /**
         * 여기에 res++ 을 달면 모든 재귀에서 끝에 res++을 하고 나오기 때문에
         * 이게 덩어리의 수를 나타내는 지표는 될 수 없음
         * */
    }
}
