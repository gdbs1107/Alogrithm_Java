package or.sopt.큰돌.week2.dfs;

import java.util.*;

public class dfs_연습_2 {

    static ArrayList<ArrayList<Integer>> adj;
    static int n = 9;
    static boolean[] visited;

    public static void main(String[] args){

        adj = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n+1];

        for (int i=0; i<10; i++){
            adj.add(new ArrayList<>());
        }

        edge(1,2);
        edge(1,4);
        edge(1,8);
        edge(2,3);
        edge(4,5);
        edge(4,7);
        edge(5,6);
        edge(8,9);

        dfs(1);

    }

    static void edge(int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    static void dfs(int start){
        // 우선 방문처리하고
        visited[start] = true;
        System.out.println(start+"탐색");

        // 자신의 인접 노드를 탐방한다
        for (int i=0; i<adj.get(start).size(); i++){
            int now = adj.get(start).get(i);

            // 발견하면 바로 재귀
            if (!visited[now]) {
                dfs(now);
            }
        }
    }
}
