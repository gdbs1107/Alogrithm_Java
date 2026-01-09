package or.sopt.week2.bfs;

import java.util.*;

public class bfs_연습 {

    /**
     * 명심하자. 1부터 시작하는 문제는 반드시 index+1을 해주고 시작해야한다
     * */
    static ArrayList<ArrayList<Integer>> adj;
    static int n = 9;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        adj = new ArrayList<ArrayList<Integer>>();
        visited = new int[n+1];

        for (int i=0; i<10; i++){
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

        // 시작점을 방문처리하고
        visited[1] = 1;
        queue.offer(1);

        // 시작점부터 쭉 내려간다
        while (!queue.isEmpty()){

            int now = queue.poll();
            System.out.println(now+"를 탐색중입니다");

            for (int i=0; i<adj.get(now).size(); i++){
                int next = adj.get(now).get(i);

                if (visited[next]==0){
                    visited[next] = visited[now]+1;
                    queue.offer(next);
                }
            }

        }

    }

    static void edge(int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

}
