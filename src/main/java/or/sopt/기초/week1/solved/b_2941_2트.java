package or.sopt.기초.week1.solved;

import java.io.*;

public class b_2941_2트 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = 0;

        for (int i=0; i<input.length(); i++){

            // d (dz= 를 z= 보다 먼저 잡아야 함)
            if (input.charAt(i) == 'd'){

                // dz=
                if (i + 2 < input.length() && input.charAt(i+1) == 'z' && input.charAt(i+2) == '=') {
                    cnt++;
                    i += 2;          // (3글자 소비) for문 i++까지 포함해서 총 3칸 이동
                    continue;
                }

                // d-
                if (i + 1 < input.length() && input.charAt(i+1) == '-') {
                    cnt++;
                    i += 1;          // (2글자 소비) for문 i++까지 포함해서 총 2칸 이동
                    continue;
                }
            }

            // c
            if (input.charAt(i) == 'c'){
                // c=
                if (i + 1 < input.length() && input.charAt(i+1) == '=') {
                    cnt++;
                    i += 1;
                    continue;
                }
                // c-
                if (i + 1 < input.length() && input.charAt(i+1) == '-') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }

            // lj
            if (i + 1 < input.length() && input.charAt(i) == 'l' && input.charAt(i+1) == 'j'){
                cnt++;
                i += 1;
                continue;
            }

            // nj
            if (i + 1 < input.length() && input.charAt(i) == 'n' && input.charAt(i+1) == 'j'){
                cnt++;
                i += 1;
                continue;
            }

            // s=
            if (i + 1 < input.length() && input.charAt(i) == 's' && input.charAt(i+1) == '='){
                cnt++;
                i += 1;
                continue;
            }

            // z=
            if (i + 1 < input.length() && input.charAt(i) == 'z' && input.charAt(i+1) == '='){
                cnt++;
                i += 1;
                continue;
            }

            // 일반 문자
            cnt++;
        }

        System.out.print(cnt);
    }
}