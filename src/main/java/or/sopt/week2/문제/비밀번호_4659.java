package or.sopt.week2.문제;

import java.util.*;
import java.io.*;


public class 비밀번호_4659 {

    static String o = "is acceptable.";
    static String x = "is not acceptable.";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> moeum = new ArrayList<>();

        moeum.add('a');
        moeum.add('e');
        moeum.add('i');
        moeum.add('o');
        moeum.add('u');

        while(true){

            int mo_cnt = 0;
            int ja_cnt = 0;
            boolean result_flag = true;
            boolean moeum_flag = false;

            String input = br.readLine();
            System.out.println("input: " + input);
            char ex_target = 'e';

            // end로 끝나면 입력 종료
            if (input == "end"){
                break;
            }

            for (int i=0; i<input.length(); i++){

                // 현재 글자가 이전 글자와 같으면 -> 두 번이상이면 false
                char target = input.charAt(i);
                if (ex_target==target){
                    if (target != 'e' && target != 'o'){
                        result_flag = false;
                        break;
                    }
                }

                // 글자가 모음이면 모음++, 자음은 0으로 초기화
                if (moeum.contains(target)){
                    mo_cnt++;
                    ja_cnt = 0;
                    moeum_flag = true;

                    // 모음이 세번 연속이면 결과 false
                    if (mo_cnt>2){
                        result_flag = false;
                        break;
                    }

                }else{
                    mo_cnt = 0;
                    ja_cnt++;

                    if (ja_cnt>2){
                        result_flag = false;
                        break;
                    }
                }
            }

            if (!moeum_flag){
                result_flag = false;
            }

            StringBuilder sb = new StringBuilder();
            if (result_flag){
                sb.append('<').append(input).append('>').append(" ").append(o);
            }else{
                sb.append('<').append(input).append('>').append(" ").append(x);
            }

        }

    }
}
