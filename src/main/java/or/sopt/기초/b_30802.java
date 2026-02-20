package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b_30802 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 이걸 하지 말고 그냥 바로 결과값에 더해버리는게 나았음
        // 딱 떨어지는 경우만 그냥 cnt로 보내고 그게 아닌 경우만 +1하는거로
        int[] shirts = new int[6];
        for (int i=0; i<6; i++){
            shirts[i] = (arr[i]+(t-1))/t;
        }

        int res = 0;
        for (int i=0; i<6; i++){
            res = res+shirts[i];
        }

        System.out.println(res);
        System.out.print((n/p)+" ");
        System.out.print((n%p)+" ");
    }

}
