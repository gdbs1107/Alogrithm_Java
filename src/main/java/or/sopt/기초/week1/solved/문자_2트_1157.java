package or.sopt.기초.week1.solved;

import java.io.*;

public class 문자_2트_1157 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[26];

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            // 소문자인 경우
            if ('a'<=c && 'z'>=c){
                arr[c-97]++;
            }

            // 대문자인 경우
            if ('A'<=c && 'Z'>=c){
                arr[c-65]++;
            }
        }

        int max = -1;
        boolean flag = false;
        char result = 'a';

        for (int i=0; i<26; i++){
            // max보다 arr이 큰 경우 result값이랑 max 초기화
            if(arr[i]>=max){

                // 두 값이 같은 경우 flag를 바꾼다
                if (arr[i]==max){
                    flag=true;
                    continue;
                }

                // 값이 큰 경우엔 두 값을 초기화하고 동시에 flag도 false로 바꿔준다
                max = arr[i];
                result = (char)(i+65);
                flag=false;
            }
        }


        if (flag){
            System.out.print("?");
        }else{
            System.out.print(result);
        }
    }
}
