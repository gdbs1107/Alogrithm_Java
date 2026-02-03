package or.sopt.큰돌.week2.문제;

import java.util.*;
import java.io.*;

public class 괄호_9012 {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            String input = br.readLine();
            Stack<Character> stk = new Stack<>();
            boolean flag = true;

            for (int j=0; j<input.length(); j++){
                char c = input.charAt(j);

                if (c == '('){
                    stk.push(c);
                } else if (c == ')'){

                    // 스택이 비어있거나 피크가 같지 않다면
                    if (stk.isEmpty() || stk.peek() == ')'){
                        flag = false;
                        break;
                    }
                    stk.pop();
                }
            }

            if (!flag || !stk.empty()){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }
        }

        System.out.print(sb);
    }

}
