package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b10828 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        for (int i=0; i<n; i++){
            String input = br.readLine();

            if (input.contains("push")){
                StringTokenizer st = new StringTokenizer(input);
                st.nextToken();
                int tar = Integer.parseInt(st.nextToken());
                stk.push(tar);
                continue;
            }

            if (input.equals("pop")){

                if (stk.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stk.pop());
                }
                continue;
            }

            if (input.equals("size")){

                System.out.println(stk.size());
                continue;
            }

            if (input.equals("empty")){
                if (stk.empty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                continue;
            }

            if (input.equals("top")){

                if (stk.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stk.peek());
                }
                continue;
            }


        }
    }
}
