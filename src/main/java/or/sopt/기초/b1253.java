package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1253 {

    /**
     * 숫자 n개가 주여질때, 그 중 본인이 아닌 다른 수 두개로 본인이 만들어지면 좋은 수라는거임
     * 원래대로면 수 하나 잡고 무한 반복문 돌리면 되긴하는데 그건 아닐 것 같고
     * 일단 수 하나 잡는건 맞는 것 같은데
     * 그러고 투포인터? 괜찮은 것 같다.
     *
     * 배열 받고 정렬
     * 1. 본인보다 크다 -> end--
     * 2. 본인보다 작다 -> start++
     * 3. 본인이랑 같다 -> 답으로 올림
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(num);

        int res = 0;
        for (int i=0; i<n; i++) {
            long target = num[i];
            int start = 0;
            int end = n-1;

            while (start<end){

                // 만약 start나 end가 본인이면 skip 해야함
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }

                long temp = num[start] + num[end];
                if (temp<target) start++;
                else if (temp>target) end--;
                else {
                    res++;
                    break;
                }
            }
        }

        System.out.print(res);
    }
}
