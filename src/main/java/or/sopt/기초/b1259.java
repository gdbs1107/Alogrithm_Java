package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1259 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String input = br.readLine();
            // 0이면 반복을 종료한다
            if (input.equals("0")) break;
            int len = input.length();
            boolean flag = false;

            // StringBuffer를 이용해서 문자열을 뒤집는다
            StringBuffer sf = new StringBuffer(input);
            String reverse = sf.reverse().toString();

            // 원래의 문자열과 뒤집은 문자열의 각 자리수를 비교한다
            for (int i=0; i<len; i++){

                // 이때 각 자리수가 같지 않다면 flag를 true로 바꾸고 자리수 비교를 종료한다
                if(input.charAt(i) != reverse.charAt(i)){
                    flag =true;
                    break;
                }
            }

            // flag가 True라면 일치하지 않음을 의미하기 때문에 No
            if (flag){
                sb.append("no").append("\n");
            }else{
                sb.append("yes").append("\n");
            }
        }

        System.out.print(sb);
    }
}
