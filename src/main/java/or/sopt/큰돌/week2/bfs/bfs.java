package or.sopt.큰돌.week2.bfs;

import java.util.*;

public class bfs {

    static boolean[] visited = new boolean[7]; //방문 배열 초기화
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] A = new ArrayList[7]; //ArrayList 타입 배열 선언
    static ArrayList<Integer> procedure = new ArrayList<>(); //탐색 순서 출력을 위한 리스트

    public static void main(String[] args){
        //ArrayList 형 배열 A 초기화
        for(int i=1;i<=6;i++) {
            A[i] = new ArrayList<>();//배열의 각 요소마다 ArrayList를 가진다.
        }
        //위의 예제 인접 리스트 초기화
        A[1].add(2);
        A[1].add(3);
        A[2].add(5);
        A[2].add(6);
        A[3].add(4);
        A[4].add(6);

        BFS(1);

        System.out.println(procedure.toString()); //[1, 2, 3, 5, 6, 4]
    }

    private static void BFS(int start){

        // 시작지점을 넣고 시작지점 방문처리
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){

            // queue의 가장 앞 노드를 가져오고
            int now = queue.poll();

            // poll() 할때, 탐색순서 리스트에 넣어주고,방문배열을 true로 바꿔준다.
            procedure.add(now);
            visited[now] = true;

            // 꺼낸 노드의 인접노드를 전부 확인한다.
            for(int i=0;i<A[now].size();i++){
                int node = A[now].get(i);

                //인접노드가 방문한적 없는 노드면 queue에 넣어준다.
                if(!visited[node]){
                    queue.offer(node);
                }
            }
        }
    }
}
