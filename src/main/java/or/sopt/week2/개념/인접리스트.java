package or.sopt.week2.개념;

import java.util.*;

public class 인접리스트 {

    static int n, m , answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 가장 바깥의 ArrayList를 만들고 내부에 n개의 ArrayList를 만든다
        // 어차피 list는 내부 인덱스를 동적할당하니까 굳이 인덱스를 지명해줄 필요가 없음
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];

        //인접 리스트 인덱스 리스트가 노드가 되고, 인덱스 리스트 안에 있는 Integer들이 노드에서 갈 수 있는 접점들이다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번째 ArrayList를 꺼내서 거기에 b를 삽입한다 + 무방향 그래프임을 고려하여 반대쪽도 넣어줌
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }


    static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (Integer nv : graph.get(v)) {
                //DFS(1)을 예를 들면 graph.get(1) = 1에 갈수 있는 노드 nv = 2,3,4 이다.
                if (ch[nv] == 0) {
                    //가려고 하는 접점이 0이라면, 거치지 않았던 곳이라면,
                    //갔다는 표시를 하고
                    ch[nv] = 1;
                    //해당 접정을 DFS 실행
                    DFS(nv);
                    //끝나면 거쳤다는 표시를 삭제
                    ch[nv] = 0;

                    //그리고 다시 DFS(1) 에서 갈 수 있는 접점 nv => 3을 실행한다. (nv =2 가 끝나면)
                }
            }
        }
    }
}