package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 비밀번호_3트_4659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr;
        boolean flag = true;
        String input;
        String o = " is acceptable.";
        String x = " is not acceptable.";

        while (!(input=br.readLine()).equals("end")){
            arr = input.toCharArray();
            char prev = '.';
            int count = 0;

            for (char c : arr){
                if (isValid(c)) flag = true;
                if (prev == c) {count++;} else {count=1;}

                if (count>2 || (prev ==c && (c!='e' && c!='o'))){
                    flag = false;
                    break;
                }

                prev = c;
            }

            StringBuilder sb = new StringBuilder();
            if (flag){
                sb.append("<").append(input).append(">").append(o);
            }else {
                sb.append("<").append(input).append(">").append(x);
            }

            System.out.println(sb);
        }

    }


    static boolean isValid(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
