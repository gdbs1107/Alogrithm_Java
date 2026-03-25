package or.sopt.기초;

import java.util.*;
import java.io.*;


public class b1654 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lans = new int[k];

        long max = 0;
        long min = 1;

        for (int i=0; i<k; i++){
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,lans[i]);
        }

        max++;


        // 이분 탐색 시작
        while (min<max){

            // count를 초기화 해주고
            long count = 0;

            // mid의 길이를 계산한다
            long mid = (min+max)/2;

            // 랜선의 길이를 측정하고 이를 count에 저장한다
            for (int i=0; i<k; i++){
                count += lans[i]/mid;
            }

            // 만약 count<n 이라면 -> 줄이 더 작아져야한다 -> hi = lo
            if (count<n){
                max = mid;
            }

            // 만약 count>n 이라면 -> 줄이 더 길어져야한다 -> mid = lo+1
            if (count>=n){
                min = mid+1;
            }
        }

        System.out.println(min - 1);

    }

}
