package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11050 {

    // n!/k!*(n-k)!

    static int n;
    static int k;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int result = fac(n)/(fac(k)*fac(n-k));
        System.out.print(result);
    }

    static int fac(int n){

        int temp = 1;
        for (int i=n; i>=1; i--){
            temp = temp*i;
        }

        return temp;
    }
}
