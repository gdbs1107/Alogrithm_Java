package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11659_누적합 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        int[] sum = new int[n+1];
        sum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++){
            int temp = Integer.parseInt(st.nextToken());
            num[i] = temp;
            sum[i] = sum[i-1] + temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result = sum[end] - sum[start-1];

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
