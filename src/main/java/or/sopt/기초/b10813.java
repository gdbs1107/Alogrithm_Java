package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 배열을 두고
 * arr[x] = y;
 * arr[y] = x
 *
 * arr[1] = 1
 * arr[2] = 2
 * arr[3] = 3
 * 일때 1 3이 들어온다면
 *
 * arr[x] = y
 * arr[y] = x 이니까
 * arr[1] = 3
 * arr[3] = 1 -> 3 2 1
 *
 * 여기서 2 3이 들어온다면 기댓값은 3 1 2
 * arr[2] = 2가 되어버리는구나 2가 아닌데
 * 그러면
 * arr[x] = y 가 안;리 결국 arr[x] = arr[y]가 되어야하고
 * arr[x]를 잠시 temp에 넣어두고
 * temp = arr[x]
 * arr[x] = arr[y]
 * arr[y] = temp
 * */
public class b10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++){
            arr[i] = i;
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}
