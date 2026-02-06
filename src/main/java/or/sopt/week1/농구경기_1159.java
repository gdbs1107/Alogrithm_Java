package or.sopt.week1;

import java.util.*;
import java.io.*;


public class 농구경기_1159 {


    /**
     * 1. System.out.print((char)result[j]+97); 첨에 이렇게 적어놨엇음
     * 근데 이렇게 하면 result[j] 내부의 값에 대해서 문자열로 바꾸게 되니까 이렇게 하는게 아니라
     *
     * j자체를 아스키코드로 바꿔야하고, 아스키 코드로 바뀌기 전 97을 더해야하니까 괄호도 추가해줘야함.
     *
     *
     * 2. flag를 잘 쓰자
     * */
    public static void main(String[] args) throws IOException {

        int[] result = new int[26];
        boolean flag = false;

        // 선수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 다 돌면서 인덱스 올리기 -> 만약 하나라도 5가 넘어간다면 flag == true로 전환
        for (int i=0; i<n; i++){
            String member = br.readLine();
            char c = member.charAt(0);

            result[c-97]++;
            if (result[c-97]>4){
                flag = true;
            }
        }

        //flag = true라면 바로 다 돌면서 그냥 출력한다
        if (flag) {
            for (int j=0; j<26; j++){
                if (result[j]>4){
                    System.out.print((char)(j+97));
                }
            }
        }else {
            System.out.println("PREDAJA");
        }

    }

}
