package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

/**
 * 틀림
 * 그냥 아예 아이디어 자체가 안떠오르는 문제....뭐 어떻게 접근해야할지도 모르겠음
 *
 * 모를떈 브루트포스 -> 즉 그냥 0부터 범위까지 쭉 돌리는거임
 * 쭉 돌리면서 문제가 발생했을때 break하는 방식
 * */
public class 영화감독_1436 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 666;

        while (true){
            if (String.valueOf(num).contains("666")) cnt++;
            if (cnt == n){
                System.out.print(num);
                break;
            }
            num++;
        }
    }
}
