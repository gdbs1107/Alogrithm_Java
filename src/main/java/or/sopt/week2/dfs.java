package or.sopt.week2;

import java.util.ArrayList;

public class dfs {

    static int n = 5;
    static ArrayList<ArrayList<Integer>> adj;

    static boolean[] visited = new boolean[n+1];

    public static void main(String[] args){

        adj = new ArrayList<ArrayList<Integer>>();

        for (int i=0; i<n+1; i++){
            adj.add(new ArrayList<Integer>());
        }

        edge(1,2);
        edge(1,3);
        edge(2,4);
        edge(2,5);

        for (int i=1; i<n+1; i++){
            System.out.println(adj.get(i));
        }

        dfs(1);
    }


    public static void edge(int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public static void dfs(int start){
        visited[start] = true;

        System.out.println(start+"로 부터 시작");

        for (int i=0; i<adj.get(start).size(); i++){
            int next = adj.get(start).get(i);
            if(!visited[next]){
                dfs(next);
            }
        }

        System.out.println(start+"로 부터 시작한 함수가 종료");
    }
}
