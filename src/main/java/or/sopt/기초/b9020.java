package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 신기한 이론이군
 *
 * 테스트 케이스를 모두 받고 테스트케이스의 최고 숫자를 구한다
 * 그리고 그 최고숫자까지의 수중에서 소수를 모두 골라낸다
 *
 * 그리고 그 수들 사이에서 테스트 케이스를 만들 수 있는 수를 찾는다
 *
 * 그럼 어떻게 소수를 찾더라?
 * 우선 긴 배열을 만들고 모두 소수라고 가정하는 boolean 배열을 만든다
 *
 * 그리고 a가 들어오면: a가 소수인 경우 그의 배수들을 모두 false로 전환한다
 * */
public class b9020 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] num = new int[tc];
        int max = 0;

        for (int i=0; i<tc; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }

        boolean[] prime = new boolean[max+1];
        for (int i=2; i<max; i++){
            prime[i] = true;
        }

        for (int i=0; i<max; i++){
            if (!prime[i]) continue;

            int j = i*2;
            while (j<=max){
                prime[j] = false;
                j += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            // n/2부터 내려가면서 가장 차이 적은 소수쌍 찾기
            for (int i = n / 2; i >= 2; i--) {
                if (prime[i] && prime[n - i]) {
                    sb.append(i).append(" ").append(n - i).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
