package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2579 {

    static int N;
    static int[] stairs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        stairs[0] = 0;

        for (int i=1; i<N+1; i++){
            stairs[i+1] = Integer.parseInt(br.readLine());
        }

        // 이전에 1이었는지를 나타내는 flag. true라면 이전에 하나의 층을 올라왔다는 것임
        System.out.print(fun(0,false,0));
    }

    static int fun(int n, boolean flag, int score){

        if (n==N){
            return score;
        }

        // n이 N-1인 경우
        if (n==N-1){
            return fun(n+1, true, score+stairs[n]);
        }

        // n이 N-2인 경우
        if (n==N-2){
            return fun(n+2, true, score+stairs[n]);
        }

        if (flag){
            return fun(n+2,false, score+stairs[n]);
        }else{
            return Math.min(fun(n+2,false, score+stairs[n]),
                    fun(n+1,true, score+stairs[n]));
        }
    }
}
