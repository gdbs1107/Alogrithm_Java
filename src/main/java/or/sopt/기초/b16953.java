package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b16953 {

    static long a;
    static long b;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        fun(a, 1);

        if (result == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(result);
    }

    static void fun(long now, int depth) {
        if (now > b) return;

        if (now == b) {
            result = Math.min(result, depth);
            return;
        }

        long temp = Long.parseLong(String.valueOf(now) + "1");

        fun(now * 2, depth + 1);
        fun(temp, depth + 1);
    }
}