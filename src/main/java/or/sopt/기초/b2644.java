package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 여러 부모 자식들의 관계가 주어졌을떄, 주어진 두 사람의 촌수를 구하는 문제
 * x y로 나오는데 x가 y의 부모임
 *
 * 처음 주어진 n이 전체 사람의 수
 * 그리고 그 다음 x y가 두 타겟
 * 그 다음 관계의 수 m 그리고 m번 나옴
 *
 * 그러면 연결리스트를 n개 만들어두고(근데 1부터 시작하니까 n+1) 만들고
 * 타겟을 저장함 tar_x, tar_y
 * 그리고 연결리스트 연결함
 *
 * 그리고 BFS를 해야겠지. tar_x부터 싲가해서 y에 도달하는 count를 출력하면 되고
 * 그러면 방문처리가 있어야하니까 visited[n+1];
 *
 * static 큐
 * static 방문처리
 * static n,m
 * static tar x, tar y
 * */
public class b2644 {

    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;

    static int tar_x;
    static int tar_y;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        tar_x = Integer.parseInt(st.nextToken());
        tar_y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        // A에 대한 촌수를 계산하기 위해 존재하는 distance 배열
        int[] distance = new int[n+1];
        queue.offer(tar_x);
        visited[tar_x] = true;

        while(!queue.isEmpty()){
            int tar = queue.poll();
            if (tar==tar_y){
                // 큐에 넣는 순간 +1을 하기 때문에 마지막에 +1을 할 필요가 없음
                System.out.println(distance[tar]);
                return;
            }
            ArrayList<Integer> temp = adj.get(tar);

            for (int a : temp) {
                if (!visited[a]) {
                    queue.offer(a);

                    // tar와 연결된 모든 노드에 해당하는 지점을 큐에 넣은거임
                    // 그러니까 tar에서 한칸 더 갔다는 것을 의미하므로 distance[tar]에 +1을 한 값으로 덮어 씌우는거임
                    distance[a] = distance[tar] + 1;
                    visited[a] = true;
                }
            }
        }

        System.out.println(-1);
    }
}
