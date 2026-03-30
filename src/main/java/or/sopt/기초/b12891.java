package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b12891 {

    static int idx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3; // T
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        int[] cur = new int[4];

        // 첫 윈도우 세팅
        for (int i = 0; i < m; i++) {
            cur[idx(s.charAt(i))]++;
        }

        int count = 0;

        while (true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (cur[i] < need[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;

            // 마지막 윈도우면 종료
            if (m == n) break;

            // 슬라이딩
            int start = 0;
            for (start = 0; start < n - m; start++) {
                cur[idx(s.charAt(start))]--;
                cur[idx(s.charAt(start + m))]++;

                flag = true;
                for (int i = 0; i < 4; i++) {
                    if (cur[i] < need[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) count++;
            }
            break;
        }

        System.out.println(count);
    }
}