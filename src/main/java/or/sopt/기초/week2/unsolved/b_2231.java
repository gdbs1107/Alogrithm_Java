package or.sopt.기초.week2.unsolved;

import java.util.*;
import java.io.*;

public class b_2231{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<=n; i++){

            if (i==n){
                System.out.print(0);
            }

            String temp = String.valueOf(i);
            int res = i;
            for (int j=0; j<temp.length(); j++){
                res += Integer.parseInt(String.valueOf(temp.charAt(j)));
            }

            if (res==n){
                System.out.print(i);
                break;
            }
        }
    }
}