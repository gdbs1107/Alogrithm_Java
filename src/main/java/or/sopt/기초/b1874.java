package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1874 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> num = new Stack<>();
        Stack<Integer> res = new Stack<>();

        for (int i=n; i>0; i--){
            num.add(i);
        }

        StringBuilder sb = new StringBuilder();
        res.add(num.pop());
        boolean flag = true;

        for (int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());

            if (input > res.peek()){
                while (num.peek()!=input){
                    res.add(num.pop());
                    sb.append("+").append("\n");
                }

                res.pop();
                sb.append("-").append("\n");
            }else if(input==res.peek()){
                res.pop();
                sb.append("-").append("\n");
            }else{
                flag = false;
                break;
            }
        }

        if (flag){
            System.out.print(sb);
        }else{
            System.out.print("NO");
        }
    }
}
