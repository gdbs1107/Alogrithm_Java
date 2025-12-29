package or.sopt.week1;

import java.io.*;
import java.util.*;

public class 일곱난쟁이_순열 {

    static int[] arr = new int[9];
    static int[] pick = new int[7];
    static boolean[] visited = new boolean[9];
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        perm(0, 0);

        // found 되면 perm 내부에서 출력하고 끝남
    }

    /**
     * depth: 현재까지 뽑은 난쟁이 수 (0~7)
     * sum: 현재까지 합
     */
    static void perm(int depth, int sum) {
        if (found) return;

        if (depth == 7) {
            if (sum == 100) {
                Arrays.sort(pick);
                for (int x : pick) System.out.println(x);
                found = true;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            pick[depth] = arr[i];
            perm(depth + 1, sum + arr[i]);
            visited[i] = false;
        }
    }
}