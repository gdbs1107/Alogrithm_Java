package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1546 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        float result = 0.0F;
        int[] arr = new int[n];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            max = Math.max(temp,max);
        }

        for (int i=0; i<n; i++){
            result = result + (((float) arr[i] /max)*100);
        }

        System.out.print(result/n);
    }
}
