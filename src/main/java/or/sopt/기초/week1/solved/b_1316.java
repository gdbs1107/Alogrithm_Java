package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

public class b_1316 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i=0; i<n; i++){
            boolean flag = true;
            String input = br.readLine();
            ArrayList<Character> list = new ArrayList<>();

            for (int j=0; j<input.length(); j++){
                char c = input.charAt(j);

                if (j==0) {
                    list.add(c);
                    continue;
                }

                // 리스트의 가장 상단의 문자와 현재의 문자가 다르고 && 리스트가 그걸 포함하고 있다면 false
                if (list.get(j-1)!=c && list.contains(c)){
                    flag=false;
                    break;
                }
                list.add(c);
            }
            if (flag){
                result++;
            }
        }



        System.out.print(result);
    }
}
