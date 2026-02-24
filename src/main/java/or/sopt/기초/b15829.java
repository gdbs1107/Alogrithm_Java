package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b15829 {

    static int M = 1234567891;
    static int R = 31;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0L;

        String input = br.readLine();
        for (int i=0; i<n; i++){
            char temp = input.charAt(i);
            // char와 아스키코드 'a'를 뺀 값을 R의 자릿수의 제곱만큼 곱해준다
            result = result + (long) ((temp - 'a'+1)*Math.pow(R,i));
        }

        System.out.print(result%M);
    }

}
