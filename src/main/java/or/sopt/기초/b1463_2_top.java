package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1463_2_top {

    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        System.out.print(fun(n));
    }

    static int fun(int n){
        if (n == 1) return 0;

        if (dp[n] != 0) return dp[n];

        dp[n] = fun(n - 1) + 1;

        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], fun(n / 2) + 1);
        }

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], fun(n / 3) + 1);
        }

        return dp[n];
    }
}