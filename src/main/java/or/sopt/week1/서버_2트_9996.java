package or.sopt.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 서버_2트_9996 {

    /**
     * 문제 예시에서 한글자 주었더라도, 꼭 예외케이스를 반드시 상정하자
     *
     * 1. substring을 적극 사용하자
     * 2. 다양한 메서드를 알고 있어야하는걸까? -> reverse, substring, find 메서드만 잘 알고 있자
     * 3. 반례를 생각하자
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String[] s = pattern.split("\\*");
        String head = s[0];
        String tail = s[1];

        for(int i = 0; i < n; i++){
            String input = br.readLine();

            // 이게 반례임
            if(input.length() < head.length() + tail.length()){ // 길이가 짧을 때
                System.out.println("NE");
                continue;
            }

            if(input.substring(0,head.length()).equals(head)){ // 앞의 문자가 head와 일치할 때
                if(input.substring(input.length() - tail.length(),input.length()).equals(tail)){ // 뒤의 문자가 tail과 일치할 때
                    System.out.println("DA"); // 정답 출력
                    continue;
                }
            }
            System.out.println("NE"); // 아닌 경우 전부 NE 출력
        }
    }
}
