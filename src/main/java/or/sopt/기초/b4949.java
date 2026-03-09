package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            Stack<Character> stk = new Stack<>();
            String input = br.readLine();

            if (input.equals(".")) break;
            boolean flag = true;

            for (int i=0; i<input.length(); i++){
                char tar = input.charAt(i);
                if( tar == '[' || tar =='('){
                    stk.push(tar);
                }

                if (tar==')'){
                    if (stk.isEmpty() || stk.peek()!='('){
                        flag = false;
                        break;
                    }else {
                        stk.pop();
                    }
                }

                if (tar==']'){
                    if (stk.isEmpty() || stk.peek()!='['){
                        flag = false;
                        break;
                    }else {
                        stk.pop();
                    }
                }
            }

            if (!flag || !stk.isEmpty()){
                System.out.println("no");
            }else {
                System.out.println("yes");
            }
        }
    }

}
