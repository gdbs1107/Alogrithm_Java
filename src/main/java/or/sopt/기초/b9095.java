package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b9095 {

    static int result;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            int tar = Integer.parseInt(br.readLine());
            result = 0;
            fun(tar);

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }


    static void fun(int n){
        if (n==0){
            result++;
        }

        if (n-1>=0){
            fun(n-1);
        }

        if (n-2>=0){
            fun(n-2);
        }

        if (n-3>=0){
            fun(n-3);
        }
    }
}
