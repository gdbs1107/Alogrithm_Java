package or.sopt.큰돌.week2.문제;

import java.io.*;
import java.util.*;

// bfs로 접근한다
public class 해킹_2트_1325 {

    static ArrayList<ArrayList<Integer>> adj;
    // visited는 dfs마다 초기화 되어야함
    static int[] visited;
    static int[] cnt;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cnt = new int[n+1];

        // n개의 노드가 존재하기 때문에 n개의 인접리스트를 생성
        adj = new ArrayList<>();
        for (int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        // m개의 간선을 이어줘야함
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 단방향 매핑이어한대. 왜그럴까?
            adj.get(b).add(a);
        }

        for (int i=1; i<n+1; i++){
            visited = new int[n+1];
            // dfs i부터 시작
            int temp = bfs(i);
            max = Math.max(temp,max);
        }

        for (int i=1; i<n+1; i++){
            if(cnt[i]==max){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int n:adj.get(temp)){
                if(visited[n]==0){
                    visited[n] = 1;
                    queue.offer(n);

                    cnt[start] ++;
                }
            }
        }

        return cnt[start];
    }

}
