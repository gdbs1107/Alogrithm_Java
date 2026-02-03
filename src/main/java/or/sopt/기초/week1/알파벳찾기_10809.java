package or.sopt.기초.week1;

import java.util.*;
import java.io.*;


// 소문자는 97~122 대문자는 65~90
public class 알파벳찾기_10809 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[26];

        for (int i=0; i<26; i++){
            arr[i]=-1;
        }

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            // 만약 arr[c-65] != -1 라면 continue, 그게 아니라면 현재의 인덱스를 넣는다
            if (arr[c-97] != -1){
                continue;
            }else{
                arr[c-97] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
