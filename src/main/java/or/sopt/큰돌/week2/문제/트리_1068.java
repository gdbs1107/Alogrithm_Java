package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

public class 트리_1068 {

    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int delete;
    static int parent[];
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        // 리스트 초기화
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        int root = -1;

        // 이제 문자열 받아서 진행하는데
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            // 하나씩 확인함
            int p = Integer.parseInt(stk.nextToken());
            if (p == -1) {
                // i 노드가 바로 루트 노드
                root = i; // 루트 노드 정보를 저장함
            } else {
                graph[i].add(p);
                graph[p].add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());
        if (delete == root) {
            System.out.println(0);
            return;
        } else dfs(root);
        System.out.println(ans);
    }

    static void dfs(int v) {
        visited[v] = true;
        // 그래서 node가 지역변수여야함 -> 노드 수가 계속 바껴야하기 때문
        int nodes = 0;

        // 본인 노드의 자식 노드를 탐색한다 -> 노드가 존재하면 ++
        // 그리고 다음 dfs는 또 새로운 탐색
        for (int cur : graph[v]) {
            // delete이거나 이미 방문한 곳이라면 그냥 continue;
            // 그게 아니라면 계속 파고든다
            if (cur != delete && !visited[cur]) {
                nodes++;
                dfs(cur);
            }
        }

        if (nodes == 0) {
            ans++; // 자식 노드가 하나도 없으면 리프 노드임
        }
    }

}
