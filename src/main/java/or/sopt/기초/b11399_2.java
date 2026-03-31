package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11399_2 {
    /**
     * 아 동원이형이 왜 최단시간이라고 한지 알겠네 ㅋㅋ
     * 최단시간을 앞에 두도록 하면 최적화가 되는거잖
     * 그럼 그냥 솔티앟고 더하기?
     *
     * 1 2 3 4 이면 대기시간은
     * 0+1+(1+2)+(1+2+3)
     *
     * i=0) 0
     * i=1) 1
     * i=2) 1+1+2
     * i=3) 1+1+2+1+2+3
     *
     * 쭉 숫자가 더해지는 변수: temp (얘는 i번쨰일때 i-1번째까지 더해진 값임)
     * 결과값: res += num[i] + temp
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num  =new int[n];

        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        int temp = 0;
        int res = num[0];
        for (int i=1; i<n; i++){
            temp += num[i-1];
            res += num[i] + temp;
        }

        System.out.print(res);
    }
}
