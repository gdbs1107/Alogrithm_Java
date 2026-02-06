package or.sopt.기초.week1.unsolved;

import java.util.*;
import java.io.*;

public class b_1065{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i=1; i<=n; i++){
            String input = String.valueOf(n);
            String s = String.valueOf(i);

            if (s.length()==1){
                result++;
                continue;
            }

            if (s.length()==2){
                result++;
                continue;
            }

            int a = Integer.parseInt(s.charAt(0)+"");
            int b = Integer.parseInt(s.charAt(1)+"");
            int c = Integer.parseInt(s.charAt(2)+"");

            int temp = b-a;
            if (c-b==temp) {
                result++;
            }
        }

        System.out.print(result);
    }
}