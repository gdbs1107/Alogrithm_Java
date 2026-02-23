package or.sopt.기초;

/**
 * 소수란 무엇인가
 *
 * 소인수 분해 했을때 1과 본인밖에 안나오는 수를 의미한다
 * 소인수 분해를 어떻게 할 수 있을까
 *
 * 1~n-1까지 내부적으로 반복하면서 혹시 몫이 1이상이라면 소수가 아닌 것이지.
 *
 * for (1~n)
 * */

import java.util.*;
import java.io.*;

public class b_1978 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i=0; i<n; i++){
            int temp = arr[i];
            boolean flag = false;

            // 1은 소인수가 한개이므로 무조건 소수가 아님
            if (temp==1) continue;

            // j는 2부터 시작해야함. 그리고 n까지 도달하면 안됨
            for (int j=2; j<temp; j++){
                if (temp%j==0){
                    flag = true;
                    break;
                }
            }

            if (!flag) res++;
        }

        System.out.print(res);
    }
}
