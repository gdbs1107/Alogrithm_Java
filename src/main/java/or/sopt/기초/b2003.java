package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            // 만약 sum이 m보다 크거나 같다면
            if (sum >= m) {
                // 와중에 sum==m 이라면 카운트를 늘리고
                if (sum == m) count++;

                // sum에서 arr[start++]를 뺸다. 이건 왜 그러는거지?
                sum -= arr[start++];
            } else {
                if (end == n) break;
                sum += arr[end++];
            }
        }

        System.out.println(count);
    }
}