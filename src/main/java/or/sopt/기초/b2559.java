package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2559 {

    /**
     * 그럼 지금 이 코드를 통해서 슬라이딩 윈도우를 일반화 해보자면
     *
     * 슬라이딩 윈도우는 처음 값을 빼고, 마지막 값을 더해가는 방식으로 값이 늘어나는 방식임
     * 그래서 굳이 while을 쓸 필요가 없을 수 있음
     *
     * 그리고 초기 max값을 초기화하는 로직이 반드시 필요하담
     * */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        // 입력값 배열 삽입
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 현재 보고 이쓴ㄴ 구간의 합
        int sum = 0;
        // 지금까지 나온 구간합들 중 최댓값
        int max = 0;

        for (int i = 0; i < n; i++) {
            // 얘 덕분에 계속 오른쪽으로 윈도우가 밀릴 수 있는거임
            sum += arr[i];

            /**
             * 원래대로 쭉 가면 i==1부터 시작하니까 k개의 합이 나오지 않음
             *
             * 그래서 k개의 합이 나오면 그걸 max로 처음 초기화 하는거임
             * */
            if(i == k - 1) {
                max = sum;
            }

            /**
             * 그 다음부턴 k개의 합이 유지되니까 한칸씩 미는거임
             * sum에서 i-k를 뺀다
             * i-K: i번째에서 k개를 뺀값 -> 즉 처음 값이 되는거임
             * */
            if(i >= k) {
                sum -= arr[i - k];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);

    }

}
