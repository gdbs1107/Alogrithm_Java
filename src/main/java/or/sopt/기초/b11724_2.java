package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 아 연결요소라는 개념이
 * 동글동글하게 생긴걸 말하는거구나 마지막이 처음을 꼬리무는
 * */
public class b11724_2 {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        for (int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        for (int i=1; i<n; i++){
            if (!visited[i]){
                queue = new LinkedList<>();
                bfs(i);
            }
        }

        System.out.println(result);
    }

    static void bfs(int n){

        queue.offer(n);
        visited[n] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            ArrayList<Integer> list = adj.get(temp);
            for (int var: list){
                if (!visited[var]){
                    queue.offer(var);
                    visited[var] = true;
                }
            }
        }

        result++;

    }


}
