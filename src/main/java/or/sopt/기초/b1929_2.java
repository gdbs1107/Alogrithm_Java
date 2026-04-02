package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1929_2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // prime[i] == true  -> i는 소수라고 일단 가정
        // prime[i] == false -> i는 소수가 아님
        boolean[] prime = new boolean[m + 1];

        // 2부터 m까지는 일단 전부 소수라고 가정
        for (int i = 2; i <= m; i++) {
            prime[i] = true;
        }

        // 2부터 m까지 하나씩 확인
        for (int i = 2; i <= m; i++) {

            // 이미 소수가 아니라고 판정된 수면 넘어감
            if (!prime[i]) {
                continue;
            }

            // i가 소수라면, i의 배수들은 소수가 아님
            /**
             * j가 소수라는 것이 판명됐기 때문에 본인의 배수를 다 false로 바꿔줘야 함
             * 그 로직이 아래인데, 반복 조건을 설정해야함
             *
             * i=j*2: j*2 부터 시작하는 이유는 j의 2배수부터 시작해야지 당연히
             * j<=m: m 걍 끝 수까지 인거지
             * j+=i: j=j+i 라는건데 아 그냥 i만큼 배수를 해주는거네
             * */
            int j = i * 2;
            while (j <= m) {
                prime[j] = false;
                j = j + i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = n; i <= m; i++) {
            if (prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}