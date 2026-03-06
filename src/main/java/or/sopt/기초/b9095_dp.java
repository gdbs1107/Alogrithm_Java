package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b9095_dp {

    static Integer[] dp;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[12];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            int tar = Integer.parseInt(br.readLine());

            sb.append(fun(tar)).append("\n");
        }

        System.out.print(sb);
    }

    static int fun(int n){

        if (dp[n]==null){
            return dp[n] = fun(n-1) + fun(n-2) + fun(n-3);
        }

        return dp[n];
    }
}
