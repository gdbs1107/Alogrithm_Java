package or.sopt.큰돌.week2.문제;

import java.io.*;
import java.util.*;

/**
 * 도달한 횟수를 어느지점에서 카운팅 할 것인가
 * 정렬을 어떻게 할 것인가
 * */
public class 해킹_1325 {

    static ArrayList<ArrayList<Integer>> adj;
    // visited는 dfs마다 초기화 되어야함
    static int[] visited;
    static int[] cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        for (int i=1; i<n; i++){
            visited = new int[n+1];
            // dfs i부터 시작
            dfs(i);
        }

        System.out.print(Arrays.toString(cnt));
    }

    static void dfs(int start) {
        visited[start] = 1;
        int len = adj.get(start).size();

        for (int i=0; i<len; i++){
            int temp = adj.get(start).get(i);

            if (visited[temp]==0){
                dfs(temp);
            }
        }
        cnt[start]++;
    }
}
