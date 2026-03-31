package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2839 {

    /**
     * 느낌 딱 오죠?
     * 5부터 세고 나머지로 3세는데
     * 이때 3으로 안덜어지면 그냥 -1 보낸다
     *
     * 근데 3만으로 만들 수 있을지도 모르잖아
     * 11이 해결이 안되네
     *
     * 그러면 n을 5로 나누고, 5의 개수만큼 반복문을 돈다
     * 근데 이때 3으로 나눠지면 stop하고 개수를 저장한다
     * 그게 끝까지 안되면 -1
     * 
     * 그럼 다시 로직을 짜보자
     * int result: 이게 결과
     * int count: 5의 개수 -> 갈수록 줄어든다
     * Int temp: 임시 정답
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = Integer.MAX_VALUE;
        int count = n/5;
        for (int i=count; i>=0; i--){
            int temp = i;
            if ((n-(5*i))%3 ==0){
                temp += (n - 5 * i) / 3;
                result = Math.min(result,temp);
            }
        }

        if (result == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(result);
    }

}
