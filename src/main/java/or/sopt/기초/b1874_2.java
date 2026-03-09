package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1874_2 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int start = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){

            int value = Integer.parseInt(br.readLine());
            // start보다 들어온 value가 크다면 value가 될때까지 넣는다
            if (start<value){

                while (start!=value){
                    stk.push(start);
                    start = start+1;
                }
                // start보다 value가 작다면 NO
            }else if (start>value){
                System.out.print("NO");
                return;
            }


            stk.pop();
            sb.append("-").append("\n");
        }

        System.out.print(sb);
    }
}
