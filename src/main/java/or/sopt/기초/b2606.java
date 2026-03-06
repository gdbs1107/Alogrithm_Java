package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2606 {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        for (int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);
        System.out.println(result);
    }

    static void dfs(int n){
        visited[n] = true;
        ArrayList<Integer> tar = adj.get(n);

        for (int i:tar){
            int temp = tar.get(i);
            if (!visited[temp]){
                result++;
                dfs(temp);
            }
        }
    }
}
