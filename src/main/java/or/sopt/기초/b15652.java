package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b15652 {

    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        fun(1,0);

        System.out.print(sb);
    }

    static void fun(int at, int depth){


        if (depth==m){
            for (int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=at; i<=n; i++){
            arr[depth] = i;
            fun(i,depth+1);
        }
    }

}
