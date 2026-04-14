package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b10986 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0] = num[0];
        for (int i=1; i<n; i++){
            sum[i] = sum[i-1] + num[i];
        }

        int result = 0;
        for (int i=sum.length-1; i>=0; i--){

            // 이미 해당 칸의 합이 m보다 크거나 같다면 구간합은 절대 m을 넘을 수 없으므로 continue;
            if (sum[i]>=m) continue;

            // i-1부터 하나씩 구간합을 계산해가면서 temp==m이면 result를 올린다
            int temp = 0;
            for (int j=i-1; j>=1; j--){
                temp = sum[i] - sum[j-1];
                if (temp==m) result++;
            }
        }

        System.out.print(result);
    }

}
