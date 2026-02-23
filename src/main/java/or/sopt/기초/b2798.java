package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2798 {

    static int n;
    static int m;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fun(0,0,0);
        System.out.println(max);
    }

    /**
     * next: 다음 차례의 배열
     * cnt: 현재까지 더한 카드의 수
     * temp: 현재까지 더한 값
     * */

    /**
     * 5 21
     * 5 6 7 8 9
     * */
    static void fun(int next, int cnt, int temp){

        // cnt가 3이면 max값을 계산함
        if (cnt==3){
            if (temp<=m){
                max = Math.max(temp,max);
            }
            return;
        }

        // 그게 아니면 재귀
        if (next==n) return;
        fun(next+1, cnt+1, temp + arr[next]);
        fun(next+1, cnt, temp);
    }
}
