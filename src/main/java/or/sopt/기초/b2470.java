package or.sopt.기초;

import java.io.*;
import java.util.*;

public class b2470 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[2];
        int s=0, e=n-1, min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        while(s < e) {
            int sum = arr[s]+arr[e];

            // sum의 절댓값이 현재 min보다 작다면 해당 값을 min으로 초기화
            // 그리고 결과 병ㄹ에 추가
            if(min> Math.abs(sum)) {
                min = Math.abs(sum);

                res[0] = arr[s];
                res[1] = arr[e];

                if(sum==0) break;
            }

            // min이 더 작다면
            // 음수인 경우 start++해서 숫자를 키우고
            if(sum <0) s++;
            // 반대의 경우엔 end--로 숫자를 줄인다
            else e--;
        }

        System.out.println(res[0]+" "+res[1]);
    }
}
