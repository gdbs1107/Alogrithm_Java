package or.sopt.week1;

import java.util.*;
import java.io.*;

public class ROT13_11655 {

    /**
     * 1. 문자열을 수정할때는 반드시 String을 쓰지 말아라~
     * 2. StringBuilder 내부의 다양한 메서드들
     * */
    public static void main(String[] args) throws IOException {

        // A는 65, a는 97,
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);

        for (int i=0; i<input.length(); i++){

            if (64 < input.charAt(i) &&  input.charAt(i)< 91){
                if (input.charAt(i)+13 > 90){
                    sb.setCharAt(i, (char) (input.charAt(i)+13-26));
                }else{
                    sb.setCharAt(i, (char) (input.charAt(i)+13));
                }
            }

            if (96 < input.charAt(i) && input.charAt(i) < 123){
                if (input.charAt(i)+13 > 122){
                    sb.setCharAt(i, (char) (input.charAt(i)+13-26));
                }else{
                    sb.setCharAt(i, (char) (input.charAt(i)+13));
                }
            }
        }

        System.out.print(sb);

    }
}
