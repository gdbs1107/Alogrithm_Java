package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 좋은단어_3986 {

    /**
     * 이건 스택 자료구조를 이용하여 풀 수 있는 문제이다.
     *
     * 깊게 고민했어도 못 풀었을듯. 스택 활용법에 대해서 알아야한다
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        // 모든 문자에 대해서 실시하는데, 하나의 문자에 대해서 lenght만큼 For문을 돈다
        for (int i=0; i<N; i++){
            String input = br.readLine();
            Stack<Character> stk = new Stack<>();

            for(int j=0; j<input.length(); j++){

                if (stk.isEmpty()){
                    stk.push(input.charAt(j));
                }else{
                    if(stk.peek()==input.charAt(j)){
                        stk.pop();
                    }else{
                        stk.push(input.charAt(j));
                    }
                }
            }

            if (stk.isEmpty()){
                ans++;
            }
        }

        System.out.println(ans);

    }
}
