package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1929 {

    /**
     * 이거 그냥 소수찾기 문제랑 존2나 똑같은거같은데 -> 시간초과네
     *
     * 아 이거 n의 배수는 걍 스킵해도 됐는데,
     * 2,3,5 는 스킵해도 됨
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i=n; i<=m; i++){
            int temp = i;
            if (temp==0 || temp==1) continue;
            if (temp==2 || temp==3 || temp==5){
                sb.append(temp).append("\n");
                continue;
            }

            if (temp%3==0 || temp%2==0 || temp%5==0) continue;
            else sb.append(temp).append("\n");
        }

        System.out.print(sb);
    }
}
