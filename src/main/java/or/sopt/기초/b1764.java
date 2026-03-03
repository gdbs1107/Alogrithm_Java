package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1764 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] listen = new String[n];
        String[] see = new String[m];

        // 보도 못한 놈
        for (int i=0; i<n; i++){
            listen[i] = br.readLine();
        }

        // 듣도 못한 놈
        for (int i=0; i<m; i++){
            see[i] = br.readLine();
        }

        // 이진탐색을 통한 시간 단축을 노려보자

        /**
         * 아니 HashMap으로 생각하고 있자
         * */
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i=0; i<n; i++){
            String lTmep = listen[i];

            for (int j=0; j<m; j++){
                String sTmep = see[j];

                // 만약 listen과 see가 동일인물이라면
                if (lTmep.equals(sTmep)){
                    sb.append(lTmep).append("\n");
                    cnt++;
                    break;
                }
            }
        }


        System.out.println(cnt);
        System.out.print(sb);
    }
}
