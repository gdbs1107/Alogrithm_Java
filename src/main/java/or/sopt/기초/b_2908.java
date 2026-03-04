package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b_2908{

    // StringBuffer를 잘 쓰자 -> String의 세부 조정
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuffer sb_a = new StringBuffer(String.valueOf(a));
        StringBuffer sb_b = new StringBuffer(String.valueOf(b));

        a = Integer.parseInt(sb_a.reverse().toString());
        b = Integer.parseInt(sb_b.reverse().toString());

        System.out.print(Math.max(a,b));
    }
}