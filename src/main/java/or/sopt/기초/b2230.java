package or.sopt.기초;

import java.io.*;
import java.util.*;

public class b2230 {

    /**
     * 기본적으로 투포인터인 것 같음.
     * 그럼 쭉 정렬해두고, 만약
     * 1. 두 수를 뺀 값이 min보다 크다 -> high-1
     * 2. 두 수를 뺀 값이 M보다 작다 -> low+1
     *
     * 이렇게 하면 되는거 아니야?
     * 아니ㅐㄹ 투포인터는 맞는데, 처음부터 시작해야한대
     *
     * 그럼
     * start = 0
     * end = 0
     * 해서 차이가 m보다 작으면 end++하는거임
     * 나올 수 있는 경우의 수가 뭐가 있지?
     *
     * 1. m보다 작다 -> 차이를 벌려야하기 때문에 end++
     * 2. m보다 큰데 min보다 작다 -> 정답임. min 값을 다시 넣고 start++, end=start
     * 3. m보다 큰데 min보다 크다 -> 차이를 줄여야함. 근데 start를 올릴 순 없음 -> 그냥 답이 아니니까 start++, end=start
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];

        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (start < n && end < n) {
            int temp = num[end] - num[start];

            // temp<m 이라면 차이가 벌어져야하므로 end++을 한다
            if (temp < m) {
                end++;
            }
            // temp>=m 일때는 가장 최솟값을 Min으로 초기화한다
            else {
                min = Math.min(min, temp);
                start++;
            }

            if (start > end) end = start;
        }

        System.out.print(min);
    }
}
