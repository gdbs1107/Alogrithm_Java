package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11047 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i=n-1; i>=0; i--){

            // coin이 M보다 크면 작업이 불가능하니까 pass
            if (coins[i]<=m){
                // m을 coin으로 나눈 몫을 count에 더한다 -> 가장 큰 돈으로 구성할 수 있는 최대개수
                count += (m/coins[i]);
                // m을 Coin으로 나눈 나머지를 m으로 초기화한다. 어차피 나머지가 남을 것 이기 때문에
                m = m%coins[i];
            }
        }

        System.out.print(count);
    }
}
