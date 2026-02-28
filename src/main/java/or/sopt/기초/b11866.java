package or.sopt.기초;

import java.util.*;
import java.io.*;


/**
 * 아이디어를 어떻게 내볼 수 있을까...
 *
 * N: 사람의 수
 * K: 등차라고 해보자
 *
 * 등차수열대로 i가 0부터 계속 더해지는데
 * 만약 N보다 커지면 N으로 나눈다
 * 그리고 그 몫이 turn이 되고, 나머지가 죽는 사람이 된다면
 *
 * 그리고 죽은 사람은 리스트에 없다면, 리스트에 저장하고
 * 그 리스트의 길이가 N과 같아지면 종료
 * */


public class b11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        /*
         *  마지막 부분의 출력은 > 괄호 전에 공백이 없기 때문에
         *  일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만
         *  반복하고 마지막 원소는 그대로 출력한다.
         */
        while(q.size() > 1) {

            // i가 0부터 K-2까지 늘어난다
            // K번째가 될때까지 뒤에 있는걸 앞으로 옮기다가 K번쨰가 되면 poll을 한다
            for(int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        // 마지막 원소 출력한 뒤 > 도 붙여준다.
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }

}