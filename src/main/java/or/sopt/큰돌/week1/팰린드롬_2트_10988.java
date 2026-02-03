package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 팰린드롬_2트_10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int result = 1;

        // StringBuilder로 단어를 reverse 시키면 StringBuilder 타입의 문자열을 반환하게 된다
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        for (int i = 0; i<len; i++){

            if(input.charAt(i) != sb.charAt(i)){
                result =0;
            }
        }

        System.out.println(result);
    }

}
