package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 곱셈_1629 {

    /**
     * 분할정복 문제임
     * 숫자가 너무 크면 0.5초라는 시간제한에 맞출 수 없기 때문에 지수의 곱 성질을 이용하여 계속해서 나눠서 구하는 것이다.
     * */
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for (int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long a = (long)(Math.pow(arr[0],arr[1]));
        int result = (int)(a%arr[2]);
        System.out.print(result);
    }
}
