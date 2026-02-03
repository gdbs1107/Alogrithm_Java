package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 팰린드롬만들기_1213 {

    /**
     * 0. 사전 Map을 미리 만들어두는데, 알파벳의 개수만큼 만들고, 아래에는 카운팅을 한다 -> 그러 ㅁMap일 필요가 없지 않나?
     * 1. 문자열을 받고
     * 2. 문자열이 홀수면 홀수 하나와 짝수 여러개, 짝수면 모두 짝수인지 확인한다
     * 3. 통과한다면 이제 팰린드롬을 만들어야함
     *
     * 1. 문자열의 Length만큼의 배열을 만들고 각 자리에 문자열을 박아넣으면 될듯?
     * */



    public static void main(String[] args) throws IOException{

        // 대문자는 65~90
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabet = new int[26];
        int flag = 0;
        boolean flag2 = true;
        String result = ""  ;

        for (int i=0; i<input.length(); i++){
            alphabet[input.charAt(i)-65] ++;
        }

        // 짝수라면 홀수가 없어야함
        if (input.length()%2==0) {
            for (int i=0; i<26; i++){
                if(alphabet[i]%2 != 0){
                    flag++;
                }
            }

            if (flag>1){
                System.out.print("I'm Sorry Hansoo");
                flag2 = false;
            }
        }

        // 홀수라면 홀수가 하나보다 많으면 안됨
        if (input.length()%2 != 0){
            for (int i=0; i<26; i++){
                if(alphabet[i]%2 != 0){
                    flag++;
                }
            }

            if (flag>2){
                System.out.print("I'm Sorry Hansoo");
                flag2 = false;
            }
        }

        // StringBuilder를 통해서 앞,중간,뒷 문자열을 만들어서 넣어주는거임
        if (flag2) {

            StringBuilder sb = new StringBuilder();
            String start = "";
            String end = "";
            char mid = 0;

            for (int i=0; i<26; i++){
                for (int j=0; j<alphabet[i]/2; j++){
                    sb.append((char)(65+i));
                }
                start = sb.toString();
                end = sb.reverse().toString();
            }

            for (int k=0; k<26; k++){
                if (alphabet[k]%2==1){
                    mid = (char)(65+k);
                }
            }

            StringBuilder sb2 = new StringBuilder();
            result = sb2.append(start).append(mid).append(end).toString();
        }


        System.out.print(result);
    }
}
