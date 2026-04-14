package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11659_2 {

    /**
     * 맞아 이 코드는 무조건 시간초과 나는 코드임.
     * 그럼 어떻게 바꿀 수 있을까
     *
     * 누적합을 썼었는데 이전엔 누적합이 뭐였지?
     * 누적합은 누적합 배열을 만들고 A,B가 들어오면 A -(B-1)의 인덱스 값을 제거하는거임
     * */
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i=1; i<=n; i++){
            sum[i] = sum[i-1] + num[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum[end]-sum[start-1]).append("\n");
        }

        System.out.print(sb);
    }

}
