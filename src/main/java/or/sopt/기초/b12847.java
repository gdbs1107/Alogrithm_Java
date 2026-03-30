package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b12847 {

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

        long sum = 0;
        long max = 0;

        for (int i=0; i<n; i++){
            sum += num[i];

            if (i==m-1){
                max = sum;
            }

            if (i>=m){
                sum -= num[i-m];
                max = Math.max(max,sum);
            }
        }

        System.out.print(max);
    }
}
