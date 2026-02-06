/*
package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 트리_2트_1068 {

    static ArrayList<ArrayList<Integer>> adj;
    static int root = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 가장 겉에 있는 리스트를 초기화하고
        adj = new ArrayList<>();

        for (int i=0; i<n; i++){
            */
/**
             * 내부에 n개의 리스트를 생성함
             * 왜 인접리스트 내부에 타입을 Integer로 초기화할까?
             *
             * 이걸 안해도 된다. 그냥 new ArrayList<>();만 정의해도 내부에 객체를 넣을때 추론을 통해서 Integer로 값이 들어감.
             * 왜냐면 선언부에서 이미 ArrayList<ArrayList<Integer>> adj; 로 선언해두었기 때문
             *
             * 하지만 굳이 '추론'이라는 기능을 도입하지 않아도 내부 타입만 명시하면 로직상으로도 가독성이 올라가기 때문에 굳이? 싶음
             * *//*

            adj.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());

            if (temp == -1){
                root = i;
            }else{
                // 시작점이 i고 만나는 점이 temp
                edge(i, temp);
            }
        }
    }


    static edge(int n, int m){
        adj.get(n).add(m);
        adj.get(m).add(n);
    }

}
*/
