package or.sopt.큰돌.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기_2트_1213 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] alpha = new int[26];
        String answer ="";

        // 알파벳 배열에 빈도수를 넣는다
        for(int i=0; i<line.length(); i++) {
            int idx = line.charAt(i)-'A';
            alpha[idx]++;
        }

        // 홀수를 카운팅한다
        int isOne =0;
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i]%2!=0) isOne++;
        }

        // 홀수가 2개 이상이면 예외반환 -> 근데 이러면 홀수개의 문자열일때는 홀수가 하나도 없으면 못만드는게 아니라
        // 넌 말이되냐 홀수개의 1개 가지면서 짝수개의 length를 가지는 문자열이.......그냥 능지 이슈네
        StringBuilder sb = new StringBuilder();
        if(isOne>1) answer += "I'm Sorry Hansoo";
        else {
            for(int i=0; i<alpha.length; i++) {

                // 알파벳을 쭉 돌면서 짝수만큼 나온 문자열을 반쪽만 만든다
                for(int r=0; r<alpha[i]/2; r++) {
                    sb.append((char)(i+65));
                }
            }

            // 그리고 answer에 추가하고 반대도 reverse로 만들어둔다
            answer += sb.toString();
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for(int i=0; i<alpha.length; i++) {
                if(alpha[i]%2==1) {

                    // 홀수인 문자열을 중간에 둔다
                    sb.append((char)(i+65));
                }
            }
            answer +=sb.toString()+end;
        }
        System.out.println(answer);
    }
}

