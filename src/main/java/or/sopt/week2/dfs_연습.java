package or.sopt.week2;

import java.util.*;

public class dfs_연습 {

    static int n = 5;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited = new boolean[n+1];

    public static void main (String[] args){

        // 0~5까지의 인접리스트를 생성한다
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i =0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        edge(1,2);
        edge(1,3);
        edge(2,4);
        edge(2,5);

        dfs(1);

    }

    public static void edge(int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public static void dfs(int start){

        visited[start] = true;
        System.out.println(start+"탐색을 시작합니다");

        for (int i=0; i<adj.get(start).size(); i++){
            int next = adj.get(start).get(i);
            if (!visited[next]){
                dfs(next);
            }
        }

        System.out.println(start+"탐색을 종료합니다");
    }
}
