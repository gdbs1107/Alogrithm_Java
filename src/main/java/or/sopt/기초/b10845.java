package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * queue는 FIFO: 선입선출 구조
 * 즉 먼저 들어간게 먼저 나온다.
 *
 * queue.poll()은 가장 뒤에 있는 원소를 빼낸다 라고 생각하면 편한거임
 * */
public class b10845 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for (int i=0; i<n; i++){
            String input = br.readLine();

            if (input.startsWith("push")) {
                StringTokenizer st = new StringTokenizer(input);
                st.nextToken();
                int temp = Integer.parseInt(st.nextToken());
                last = temp;
                q.offer(temp);
                continue;
            }

            switch (input) {
                case "pop":
                    System.out.println(q.isEmpty() ? -1 : q.poll());
                    break;

                case "size":
                    System.out.println(q.size());
                    break;

                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;

                case "front":
                    System.out.println(q.isEmpty() ? -1 : q.peek());
                    break;

                case "back":
                    System.out.println(q.isEmpty() ? -1 : last);
                    break;
            }
    }
}
}
