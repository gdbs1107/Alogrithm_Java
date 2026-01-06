package or.sopt.week2;

import java.util.*;

public class 인접리스트 {

    static int n = 10;
    static List<Integer>[] g = new ArrayList[n];
    static boolean[] visited = new boolean[n];

    public static void main(String[] args) {

        // 0) 인접리스트 초기화 -> 배열 안의 요소가 리스트임
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        // 1) 간선 추가 (무방향 그래프라 양쪽에 추가)
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(3, 4);

        // 2) 0번부터 방문 안 한 노드 찾고 DFS로 이어서 방문/출력
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void addEdge(int a, int b) {
        g[a].add(b);
        g[b].add(a);
    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : g[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}