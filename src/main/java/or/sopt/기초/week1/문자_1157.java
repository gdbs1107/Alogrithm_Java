package or.sopt.기초.week1;

import java.util.*;
import java.io.*;

/**
 * 1. 아스키 코드를 굳이 숫자로 표시할 필요없다 -> 조건식할때 그냥 알파벳 쓰셈
 * */
public class 문자_1157 {

    // 대소문자를 구분하지 않네;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 알파벳의 개수만큼 배열을 만든다
        int[] arr = new int[26];

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            // 소문자 97~122
            if (96<c && 123>c){
                arr[c - 97]++;
            }

            // 대문자 65~90
            if (64<c && 91>c){
                arr[c-65]++;
            }
        }

        Arrays.sort(arr);
        char result = (char) arr[25];
        char temp = (char) arr[24];

        if (result == temp){
            System.out.print("?");
        }else{
            System.out.print(result);
        }
    }
}
