package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1182 {

    static int result = 0;
    static int[] num;
    static int n;
    static int s;

    /**
     * 지금 로직에서 공집합이라는건 어떻게 증명할 수 있을까
     * 아니지 공집합이 문제가 되는 경우는 결국 s값이 0일때잖아
     *
     * s값이 0일때는 1을 빼주면 되는거 아님?
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        fun(0,0);

        if (s==0){
            System.out.print(result-1);
        }else{
            System.out.print(result);
        }
    }

    static void fun(int temp, int depth){

        if (depth==n) {
            if (temp == s) {
                result++;
            }
            return;
        }

        fun(temp+num[depth], depth+1);
        fun(temp, depth+1);
    }
}
