package or.sopt.week2;

import java.util.*;

public class dfs_주석 {

    static int n = 5;
    static ArrayList<ArrayList<Integer>> adj;

    // 이건 왜 n+1인거임? -> 우리가 0부터 쓰는게 아니라 1부터 쓰니까 당연하지
    // 배열을 초기화할때 파라미터가 의미하는 바가 무엇일까 -> 그 인덱스임. 그니까 5넣으면 0~4가 생기는거야. 근데 length를 넣으면 길이가 5가 나온단 말이지
    // 그러니까 길이와 인덱스를 반드시 잘 구별하라
    static boolean[] visited = new boolean[n+1];

    public static void main(String[] args){

        // 여기까지는 아직 바깥쪽 ArrayList만 생성한 것. 내부에 몇개의 리스트가 존재하는지 모르기 때문에 채울 수 없음
        adj = new ArrayList<ArrayList<Integer>>();

        /**
         * 아래 반복문의 문제점은 리스트라는 자료구조를 아예 이해하지 못하고 있는거임
         *
         * 인덱스를 통해 바로 위치를 찾아서 값을 삽입 할 수 있는 정적할당방식의 배열과는 다르게 리스트는 동적할당 방식을 통해 데이터를 수납함
         * 그래서 list.add()를 하게 되면, 뒤에서부터 차례차례 데이터가 박히기 때문에
         * 내가 반복을 1부터하더라도 0~4의 리스트가 생성되는거임
         *
         * 그래서 밑의 조회에서 터지게 되는거고
         * */
        /*for (int i=1; i<n+1; i++){
            //adj[i] = new ArrayList<>();
            adj.add(new ArrayList<Integer>());
        }*/

        for (int i=0; i<n+1; i++){
            //adj[i] = new ArrayList<>();
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
