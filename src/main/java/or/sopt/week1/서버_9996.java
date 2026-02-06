package or.sopt.week1;

import java.util.*;
import java.io.*;

// 그냥 틀려버림

public class 서버_9996 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자 개수 받고
        int n = Integer.parseInt(br.readLine());

        // 패턴 받고
        String pattern = br.readLine();
        String[] patterns = pattern.split("\\*");

        String head = patterns[0];
        String tail = patterns[1];

        // 문자열을 받는다
        for (int i=0; i<n; i++){
            boolean flag = true;
            String input = br.readLine();

            if (input.length() < head.length() + tail.length()) {
                System.out.println("NE");
                continue;
            }

            // 앞에서부터 head 만큼 반복하며 검증
            for (int j=0; j<head.length(); j++){
                if (head.charAt(j) != input.charAt(j)){
                    System.out.println("NE");
                    flag = false;
                    break;
                }
            }

            // 뒤에서부터 tail 만큼 반복하며 검증
            for (int k=0; k<tail.length(); k++){
                if (tail.charAt(tail.length()-1-k) != input.charAt(input.length()-1-k)){
                    System.out.println("NE");
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.println("DA");
            }
        }
    }
}
