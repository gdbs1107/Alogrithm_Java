package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2467 {

    /**
     * 이분 탐색인 것 같은데? 대신에 절댓값으로 결과를 도출하는 문제인 것 같고
     * 그리고 완전 2470이랑 비슷하네.
     * 그럼 나올 수 있는 경우의 수ㅏㄱ 어떻게 될까
     *
     * 두 값을 더해서 0과 가까운 수를 res라고 가정하면
     * 1. res보다 절댓값이 큰 경우
     * 1-1. 근데 그 값이 음수인 경우-> 결과값을 올려야 하니까: start++
     * 1-2. 근데 그 값이 양수인 경우: end--;
     *
     * 2. res보다 절댓값이 작은 경우: res값을 초기화한다
     *
     * 근데 왜 res가 MAX_VALUE면 안되는거지?
     *
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] num = new long[n];

        for (int i=0; i<n; i++){
            num[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = n-1;
        long res = Long.MAX_VALUE;
        long[] arr = new long[2];

        while (start<end){
            long temp = num[end] + num[start];

            if (res>=Math.abs(temp)){
                res = Math.abs(temp);
                arr[0] = num[start];
                arr[1] = num[end];

            }

            // 얘를 else로 타버리면 무한 재귀에 빠져버린다. 그러니까 그렇게 하지말고 그냥 if문으로 두는거임
            if (temp < 0) {
                start++;
            } else if (temp > 0) {
                end--;
            } else {
                break;
            }
        }

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}
