package or.sopt.큰돌.week3.개념;

import java.io.*;
import java.util.*;

public class 영화감독_1436 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = 0;
        int cnt = 0;

        while (true){
            String a = String.valueOf(temp);
            if (a.contains("666")){
                cnt++;
            }

            if(cnt==n){
                break;
            }
            temp++;
        }

        System.out.print(temp);
    }
}
