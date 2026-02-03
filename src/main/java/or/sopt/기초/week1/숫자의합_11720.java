package or.sopt.기초.week1;

import java.util.*;
import java.io.*;

public class 숫자의합_11720 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int result = 0;

        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(String.valueOf(input.charAt(i)));
            result += temp;
        }

        System.out.print(result);
    }
}
