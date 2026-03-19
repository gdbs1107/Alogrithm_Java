package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 일반적인 dfs, bfs의 구현문제
 * 필요한 static 변수는
 *
 * 1. adj 인접리스트
 * 2. 방문처리용 visited 배열
 * 3. bfs용 queue
 * */
public class b1260 {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 정점만큼의 리스트 만들기
        for (int i=0; i<n+1; i++){
            adj.add(new ArrayList<Integer>());
        }

        // 간선 연결
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        sb = new StringBuilder();
        visited = new boolean[n+1];
        dfs(start);
        System.out.println(sb);

        sb = new StringBuilder();
        visited = new boolean[n+1];
        bfs(start);
        System.out.println(sb);

    }


    static void dfs(int n){
        visited[n] = true;
        sb.append(n).append(" ");
        ArrayList<Integer> list = adj.get(n);
        Collections.sort(list);

        for (int var: list){
            if (!visited[var]) dfs(var);
        }
    }

    static void bfs(int n){
        visited[n] = true;
        queue.offer(n);

        while (!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");

            ArrayList<Integer> list = adj.get(temp);
            Collections.sort(list);
            for (int var : list){
                if (!visited[var]){
                    visited[var] = true;
                    queue.offer(var);
                }
            }
        }

    }
}
