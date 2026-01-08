package or.sopt.week2.bfs;

import java.util.*;

public class bfs_간단_예제 {

    static ArrayList<ArrayList<Integer>> adj;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[9+1];

    public static void main(String[] args){

        adj = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<9+1; i++){
            adj.add(new ArrayList<>());
        }

        edge(1,2);
        edge(1,3);
        edge(1,4);
        edge(2,5);
        edge(3,6);
        edge(3,7);
        edge(6,9);
        edge(4,8);

        bfs(1);
    }

    public static void edge(int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public static void bfs(int start){
        // 시작점을 방문처리하고 q에 넣는다
        visited[start] = true;
        q.offer(start);

        // q가 존재할때까지 반복하며, start와 연결된 모든 요소를 q에 넣는다
        while (!q.isEmpty()){

            int now = q.poll();
            System.out.println(now+": 탐색중입니다");

            for (int i=0; i<adj.get(now).size(); i++){
                int node = adj.get(now).get(i);

                if (!visited[node]){
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }
    }
}
