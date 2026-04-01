package or.sopt.기초;

import java.io.*;
import java.util.*;

public class b2217 {

    /**
     * n개의 로프가 주어졌을때
     * 고르게 중량을 분포시켜서 들 수 있는 가장 큰 무게
     *
     * 그럼 가장 작은 로프부터 시작해서 들 수 있는 가장 큰 무게
     * 로프의 길이*그 뒤에 있는 로프의 개수
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for (int i=0; i<n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int result = 0;
        for (int i=0; i<n; i++){
            int temp = rope[i]*(n-i);
            result = Math.max(temp,result);
        }

        System.out.print(result);
    }
}
