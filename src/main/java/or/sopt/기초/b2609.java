package or.sopt.기초;

import java.io.*;
import java.util.*;

public class b2609  {

    static int max = 1;
    static int a;
    static int b;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        fun();
        System.out.println(max);
        System.out.println(max*a*b);
    }

    static void fun(){
        boolean flag = false;
        int min = Math.min(a,b);

        for (int i=2; i<=min; i++){

            // 만약 두 수와 i를 나눈 나머지가 모두 0인 경우
            if (a%i==0 && b%i==0){
                a = a/i;
                b = b/i;
                max = max*i;
                flag = true;
                break;
            }
        }

        if (flag){
            fun();
        }else{
            return;
        }

    }
}
