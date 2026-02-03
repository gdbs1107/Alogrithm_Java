package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 포켓몬마스터_2트_1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 숫자인 경우와 글자인 경우에 탐색속도를 늘리기 위해서 두가지의 해쉬맵을 만든다
        HashMap<Integer, String> hash1 = new HashMap<Integer, String>();
        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();


        for(int i = 1; i <= N; i++) {
            String S = br.readLine();

            // 그래서 넣을때 양방향으로 넣어주는거임
            hash1.put(i, S);
            hash2.put(S, i);
        }

        for(int i = 0; i < M; i++) {
            String S = br.readLine();
            //입력값이 번호인지 포켓몬이름인지 판별
            if(49 <= S.charAt(0) && S.charAt(0) <= 57) {

                // 와 이거 대박이다. 결과를 출력할때도 StringBuilder를 이용해서 만들 수 있구나
                // 끝에 "\n"을 이용해서 들여쓰기를 한다 -> 결국 StringBuilder가 char의 집합이라는 점을 잘 이용한 구현이다.
                sb.append(hash1.get(Integer.parseInt(S))).append("\n");
            }else {
                sb.append(hash2.get(S)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
