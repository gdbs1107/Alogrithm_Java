package or.sopt.week2.문제;

import java.io.*;
import java.util.*;

/**
 * 진짜 개답답하고 개빡치는 문제네
 * */
public class 균형_4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;

            Stack<Character> st = new Stack<>();
            boolean ok = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    st.push(c);
                } else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') { ok = false; break; }
                    st.pop();
                } else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') { ok = false; break; }
                    st.pop();
                }
            }

            if (ok && st.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.print(sb);
    }
}