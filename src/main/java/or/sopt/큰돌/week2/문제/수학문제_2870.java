package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

public class 수학문제_2870 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<n; i++){
            String input = br.readLine();

            for (int j=0; j<input.length(); j++){
                char c = input.charAt(j);

                // 만약 숫자가 발견된다면
                if (c > '0' && c < 'a'){
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);

                    // 그 다음 문자들을 탐색하면서 숫자가 나올때 멈춘다
                    for (int k = j; true; k++){
                        char next = input.charAt(k);

                        // 만약 다음문자가 알파벳이라면 -> break
                        if (next>'a'){
                            int temp = Integer.parseInt(sb.toString());
                            result.add(temp);
                            break;
                        }
                        // 그게 아니라면 숫자를 넣는다
                        sb.append(next);
                    }
                }
            }
        }

        System.out.print(result);
    }
}
