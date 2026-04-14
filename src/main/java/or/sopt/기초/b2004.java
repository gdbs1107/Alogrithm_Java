package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2004 {

    /**
     * 기본적으로 조합인건데...
     * 조합 공식이 뭐였더라: n!/r!(n-r)! 이래
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long result = factorial(n)/(factorial(m)*factorial(n-m));

        System.out.println(result);

        int count = 0;
        String s = String.valueOf(result);
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i)=='0'){
                count++;
            }else{
                break;
            }
        }

        System.out.print(count);
    }

    static long factorial(int n){
        long temp = 1;
        for (int i=1; i<=n; i++){
            temp = temp*i;
        }
        return temp;
    }

}
