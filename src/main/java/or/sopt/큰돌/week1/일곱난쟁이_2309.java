package or.sopt.큰돌.week1;

import java.io.*;
import java.util.*;

public class 일곱난쟁이_2309 {

    /**
     * 2309
     *
     * 1. main문 까먹음 븅신
     * 2. java.io.* 임포트해라
     * 3. BufferedReader는 checkedException으로 IOException을 처리해야한다
     * 4. 일반 배열은 고정길이 배열이라 add() 와 같은 메서드가 존재하지 않는다 -> 이유는 당연함 add가 되려면 길이가 가변적인 배열이여아지
     *  그래서 List와 같은 자료구조를 사용할때만 가능하다. 평소에는 배열의 길이를 반드시 초기화 할 것
     *
     */
    public static void main(String[] args) throws IOException {

        int[] arr = new int[9];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for(int i=0; i<9; i++){
            int input = Integer.parseInt(bf.readLine());
            arr[i] = input;
            sum += arr[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }

}
