package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 패션왕_9375 {

    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // N개의 테스트 케이스가 동작
        for (int i=0; i<N; i++){

            // 옷을 담을 Map<이름,종류>를 만든다
            Map<String,String> clothes = new HashMap<>();
            int M = Integer.parseInt(br.readLine());

            // 의상의 갯수만큼 순회
            for (int j=0; j<M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String genre = st.nextToken();

                clothes.put(name,genre);

                // 모든 name의 갯수 + 의상별 name*의상별 name, 어떻게하면 genre의 갯수를 중복 미포함으로 계산할 수 있을까....
                // 장르를 쭉 받았음
                String s = clothes.get(name);
                StringTokenizer st2 = new StringTokenizer(s);
                /*while(true){
                    if (st2.nextToken().isNull){
                        break;
                    }*/

                }

            }


        }
    }


