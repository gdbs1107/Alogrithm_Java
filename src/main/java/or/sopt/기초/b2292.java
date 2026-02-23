package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 우선 개발 세팅부터 하면
 * depth를 기준으로 1 -> 6 -> 12 -> 18... 6의 배수개로 더해진다.
 * 18 24 30
 *
 * 1 -> 7 -> 19 -> 37 -> 61
 *
 * 그러면 n이 들어왔을때,
 *
 * */
public class b2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int depth = 0;
        int i = 6;
        int prev = 1;
        int next = 1;

        while(true){

            depth ++;

            // 만약 해당 층이 본인 층이라면 depth를 초기화하고 break
            if (prev <= n && n <= next){
                break;
            }

            // 그게 아니라면 next를 i만큼 늘려주고 i도 6증가시킴
            prev = next+1;
            next = next+i;
            i = i+6;
        }

        System.out.print(depth);

    }
}
