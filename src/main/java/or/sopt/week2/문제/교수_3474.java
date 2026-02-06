package or.sopt.week2.문제;

import java.util.*;
import java.io.*;


/**
 * 그대로 팩토리얼을 계산하면 무조건 자료타입이 넘어가니까
 * 이를 재귀적으로 해결 할 수 있는 방법이 필요함 -> 분할정복
 *
 * 10! = 5!*5!
 * 5! = 2!*3!
 * 으로 팩토리얼은 분할정복 로직 적용이 가능함
 *
 * 그리고 0의 개수를 찾는 문제니까 결국 10*10 = 100 과 같이 0으로 떨어지는 수가 나올때마다 결과같에 0이 추가되는 느낌이다
 * 이를 이용해서 해결 할 수 있어야함
 *
 * ㄴㄴ아니다 이건 분할정복까지도 필요없고
 * 결국 0의 개수를 구한다는건 인수 중 10이 몇개나 들어가야하는가를 구하는 문제인거고 -> 소인수중에는 2보단 5가 압도적으로 적으니까
 * n을 쭉 돌면서 5의 개수를 구하면ㄷ ㅚㄴ다는 결론
 * */
public class 교수_3474 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            long result = 1;
            int target = Integer.parseInt(br.readLine());

            for (int j=1; j<target+1; j++){
                result = result*j;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
