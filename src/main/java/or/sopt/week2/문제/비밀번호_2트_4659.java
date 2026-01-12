package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 비밀번호_2트_4659 {

    /**
     * 1. isVowel() 메서드의 형식을 검토하라
     * 2. toCharArray(): 문자열을 배열로 반환하는 메서드
     * 3. for (단일값:배열) -> iteration
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password;
        char[] pass;
        String acc = "> is acceptable.\n";
        String not = "> is not acceptable.\n";
        StringBuilder sb = new StringBuilder();
        boolean flag;
        char prev;
        int count;
        while (!(password = in.readLine()).equals("end")) {

            // 문자열을 쪼개서 배열로 만들어주는 메서드
            pass = password.toCharArray();
            prev = '.';
            count = 0;

            flag = false;
            for (char p : pass) {

                // 문자열이 모음이라면 true
                if (isVowel(p)) flag = true;

                // 문자열이 이전과 같지 않다면 count = 1;
                if (isVowel(p) != isVowel(prev)) count = 1;
                // 이전거랑 같다면 ++
                else count++;

                // 카운트가 2 이상이고 이전 문자가 e도 아니고 o도 아니고 이전의 문자열과 같다면
                if (count > 2 || (prev == p && (p != 'e' && p != 'o'))) {
                    flag = false;
                    break;
                }

                prev = p;
            }

            if (flag) sb.append('<').append(password).append(acc);
            else sb.append('<').append(password).append(not);
        }

        System.out.println(sb);

    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
