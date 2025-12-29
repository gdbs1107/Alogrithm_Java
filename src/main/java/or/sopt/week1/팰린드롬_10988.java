package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 팰린드롬_10988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        boolean result;

        // 길이를 기준으로 홀수와 짝수를 분별함
        if(len % 2 == 0){
            result = even(input, len);
        }else{
            result = odd(input, len);
        }

        if(result){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }

    // 홀수 일땐 중간을 뽑아서 양쪽을 for문으로 비교한다
    private static boolean odd(String input, int len){

        int mid = len/2;

        for(int i=1; i<mid; i++){
            if (input.charAt(mid-1) != input.charAt(mid+1)){
                return false;
            }
        }
        return true;
    }

    private static boolean even(String input, int len){
        int mid = len / 2;
        for (int i = 0; i<mid+1; i++){

            if(input.charAt(mid-(i-1)) != input.charAt(mid+i)){
                return false;
            }
        }
        return true;
    }
}
