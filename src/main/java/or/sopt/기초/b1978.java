package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 소수가 뭐냐면
 * 본인과 1 만을 소수로 가지는 수를 소수라고 한다
 * 그래서 전에 이거 브루트포스로 풀었던 것 같은데
 *
 * 그러니까 모든 수에 대해서 본인 아래의 수로 나눌때 나눠지면 바로 cut
 * */
public class b1978 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (temp==1 || temp==0) continue;
            if (temp==2) {
                count++;
                continue;
            }

            boolean flag = true;
            for (int j=2; j<temp; j++){
                if (temp%j==0){
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        System.out.println(count);
    }
}
