package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11000 {

    /**
     * 이거 그 전거랑 완전 ㅗㄸㄱ같아 보이는데?
     * 3
     * 1 3
     * 2 4
     * 3 5
     *
     * 예제가 이렇게 주어졌을때 답이 2인 이유는 두 개의 덩어리라 그런건가?
     * 2 4 의 수업을 어떻게 진행한다는거지?
     * 그건 알바 아니고 13 ->35, 24
     * 이렇게 두개의 강의실이 필요하다는거임
     *
     * 그럼 덩어리 수를 센다는 건가?
     * 그럼 그래프아님? 진짜 그래프 아님? 이게 왜 그리디임?
     * bfs겠네
     *
     * 오랜만에 하니까 필요한 값을 도출해보면
     * 1. 이중배열 adj
     * 2. 방문처리 단일 배열
     * 3. result
     *
     * 아 노드수를 알 수ㅏㄱ 없구나 이건 안되겠네
     * */

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1붵 시작하니까 n을 포함
        for (int i=0; i<=n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(b).add(a);
            adj.get(a).add(b);
        }

        visited = new boolean[n+1];
        for (int i=1; i<=n; i++){
            if (!visited[i]){
                queue.add(i);
                visited[i] = true;
                bfs();
                result++;
            }
        }

        System.out.print(result);
    }

    static void bfs() {
        while (!queue.isEmpty()){
            int a = queue.poll();
            ArrayList<Integer> list = adj.get(a);

            for (int var: list){
                queue.offer(var);
                visited[var] = true;
            }
        }
    }
}
