package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 트리3트 {


    static ArrayList<ArrayList<Integer>> adj;
    static int root;
    static int[] visited;
    static int cnt = 0;
    static int deleteNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new int[n];
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp == -1) {
                root = i;
                continue;
            }
            edge(temp, i);
        }

        /**
         * 이제 삭제로직을 구현하면 되는데
         *
         * 만약 root라면 그냥 바로 0을 반환하고
         * 루트가 아니라면 그 아래를 탐색하면서 만약 자식이 있다면 그 자식들을 모두 삭제한다 -> dfs
         * */
        deleteNum = Integer.parseInt(br.readLine());
        if (deleteNum == root) {
            System.out.print('0');
            return;
        } else {
            dfs(deleteNum);
        }

        System.out.println(cnt);
    }

    static void edge(int n, int m) {
        adj.get(n).add(m);
    }

    static void dfs(int n) {
        // 들어간 곳 방문처리
        visited[n] = 1;

        // 본인과 연결된 곳 탐색
        int len = adj.get(n).size();
        for (int i = 0; i < len; i++) {
            int next = adj.get(n).get(i);

            // 방문 재귀
            if (visited[next] == 0) {
                dfs(next);
            }
        }

        if (len == 0) {
            cnt++;
        }
    }
}
