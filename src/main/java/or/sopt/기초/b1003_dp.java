package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1003_dp {

    static int[][] arr;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[41][2];

        // 배열 값들을 모두 -1로 초기화
        for (int i=0; i<41; i++){
            for (int j=0; j<2; j++){
                arr[i][j] = -1;
            }
        }

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            fibo(temp);
            sb.append(arr[temp][0]).append(" ").append(arr[temp][1]).append("\n");
        }

        System.out.print(sb);

    }

    static int[] fibo(int n){
        if (arr[n][0]==-1 && arr[n][1]==-1){
            arr[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            arr[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }

        return arr[n];
    }
}
