package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2231 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;

        for (int i=1; i<n; i++){
            String temp = String.valueOf(i);
            int result = i;

            for (int j=0; j<temp.length(); j++){
                char c = temp.charAt(j);
                int a = Integer.parseInt(String.valueOf(c));
                result += a;
            }

            if (result==n) {
                System.out.print(i);
                flag = true;
                break;
            }
        }

        if (!flag) System.out.print(0);

    }

}
